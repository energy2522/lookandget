package pack;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Володимир Майборода on 19.12.2017.
 */
public class Submit implements Runnable{
    private static final String URL = "http://192.168.43.186:8080/lookandget/server/admin/image/emotion";
    private final String INFO_CLIENT;
    private final byte[] IMAGE;


    public Submit(byte[] image, String infoClient) {
        IMAGE = image;
        INFO_CLIENT = infoClient;
    }

    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder(INFO_CLIENT).append(",").append(" \"image\" : \"");

        String base64String = org.apache.commons.codec.binary.Base64.encodeBase64String(IMAGE);

        stringBuilder.append(base64String).append("\" }");

        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(stringBuilder.toString());
        } catch (UnsupportedEncodingException e) {
            System.out.println("error set StringEntity!");
            return;
        }

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(stringEntity);

        try {
            httpClient.execute(httpPost);
        } catch (IOException e) {
            System.out.println("Submit error!");
        }
    }
}
