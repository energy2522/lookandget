package com.getandlook.service.impl;

import com.getandlook.module.ImageReq;
import com.getandlook.module.ImageRequest;
import com.getandlook.module.domain.Client;
import com.getandlook.module.domain.ContentOfClient;
import com.getandlook.module.domain.TypeContent;
import com.getandlook.module.image.interfaces.ImageProcessing;
import com.getandlook.service.interfaces.CreateService;
import com.getandlook.service.interfaces.FindService;
import com.getandlook.service.interfaces.ImageService;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Map;

/**
 * Service implements interface {@ling ImageService}
 * @author Володимир Майборода
 */

@Path("/admin/image")
@Service
public class ImageServiceImpl implements ImageService {
    private static final Logger LOG = LogManager.getLogger(ImageServiceImpl.class);

    @Autowired
    private ImageProcessing imageProcessing;

    @Autowired
    private FindService findService;

    @Autowired
    private CreateService createService;


    @POST
    @Path("/emotion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getEmotionFromPhoto(ImageReq req) {
        ContentOfClient contentOfClient = new ContentOfClient();
        Client client;

        client = findService.findClientById(req.getIdClient());

        if (client == null) {
            LOG.warn("Don't found client with id {}", req.getIdClient());
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
        }

        Map<String, Double> allEmotion = imageProcessing.getEmotionFromImage(convert(req.getImage()));

        //set content of client
        contentOfClient.setAnger(allEmotion.get("anger"));
        contentOfClient.setContempt(allEmotion.get("contempt"));
        contentOfClient.setDisgust(allEmotion.get("disgust"));
        contentOfClient.setFear(allEmotion.get("fear"));
        contentOfClient.setHappiness(allEmotion.get("happiness"));
        contentOfClient.setNeutral(allEmotion.get("neutral"));
        contentOfClient.setSadness(allEmotion.get("sadness"));
        contentOfClient.setSurprise(allEmotion.get("surprise"));
        contentOfClient.setContent(getTypeContent(req.getTypeOfContent()));
        contentOfClient.setClient(client);
        contentOfClient.setMap(allEmotion);

        createService.createContentFotClient(contentOfClient);

        return Response.status(Response.Status.OK).build();
    }

    private TypeContent getTypeContent(String name) {
        TypeContent typeContent;

        if (findService.isExistsTypeContent(name)) {
            typeContent = findService.findTypeContentByName(name);
        } else {
            typeContent = new TypeContent(name);
            createService.createTypeContent(typeContent);
            typeContent = findService.findTypeContentByName(name);
        }

        return typeContent;
    }

    public byte[] convert(String encodedString) {
        LOG.info("Encoded string {}", encodedString);
        byte[] image = Base64.decodeBase64(encodedString);

        return image;
    }


}
