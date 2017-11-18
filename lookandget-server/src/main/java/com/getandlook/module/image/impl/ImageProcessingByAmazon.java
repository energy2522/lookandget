package com.getandlook.module.image.impl;

import com.getandlook.module.image.interfaces.ImageProcessing;
import com.getandlook.service.impl.ImageServiceImpl;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Володимир Майборода on 18.11.2017.
 */
@Component
public class ImageProcessingByAmazon implements ImageProcessing {
    private static final Logger LOG = LogManager.getLogger(ImageServiceImpl.class);
    private static final String URL = "https://westus.api.cognitive.microsoft.com/emotion/v1.0/recognize";
    private static final String NAME = "Ocp-Apim-Subscription-Key";
    private static final String KEY = "1f968aebf77745ab821d7d0557e95323";

    @Override
    public Map<String, Double> getEmotionFromImage(String path, String type) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        AbstractHttpEntity startEntity;

        try {
            URIBuilder uriBuilder = new URIBuilder(URL);

            URI uri = uriBuilder.build();
            HttpPost request = new HttpPost(uri);

            request.setHeader(NAME, KEY);
            if (type.equals("image")) {
                startEntity = new ByteArrayEntity(getByteArrayByPath(path),
                        ContentType.APPLICATION_OCTET_STREAM);
            } else {
                startEntity = new StringEntity("{ \"url\": \"" + path + "\" }",
                        ContentType.APPLICATION_JSON);

            }

            request.setEntity(startEntity);

            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();


            String stringEntity = EntityUtils.toString(entity);

            LOG.info(startEntity);

            JSONArray jsonArray = new JSONArray(stringEntity.toString());

            Map<String, Double> allEmotion = getEmotion(jsonArray);

            return allEmotion;

        } catch (Exception e) {
            LOG.catching(e);
            return null;
        }
    }

    public static String getMostEmotion(Map<String, Double> map) {
        String name = "";
        Double value = 0d;

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > value) {
                value = pair.getValue();
                name = pair.getKey();
            }
        }

        return name;
    }

    //return array of byte from image
    private byte[] getByteArrayByPath(String pathToImage) throws IOException {
        File imgPath = new File(pathToImage);

        if (!imgPath.exists()) {
            throw new FileNotFoundException();
        }

        return Files.readAllBytes(imgPath.toPath());
    }

    //method parses JSONArray and return map with summary emotion
    private Map<String, Double> getEmotion(JSONArray jsonArray) {
        Map<String, Double> resultMap = new HashMap<>();
        resultMap.put("contempt", 0d);
        resultMap.put("surprise", 0d);
        resultMap.put("happiness", 0d);
        resultMap.put("neutral", 0d);
        resultMap.put("sadness", 0d);
        resultMap.put("disgust", 0d);
        resultMap.put("anger", 0d);
        resultMap.put("fear", 0d);

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i).getJSONObject("scores");

            for (Map.Entry<String, Double> entry : resultMap.entrySet()) {
                String type = entry.getKey();
                Double typeValue = entry.getValue();

                typeValue += jsonObject.getDouble(type);

                resultMap.put(type, typeValue);
            }
        }

        return resultMap;
    }

}
