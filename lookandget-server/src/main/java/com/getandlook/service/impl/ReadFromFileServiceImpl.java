package com.getandlook.service.impl;

import com.getandlook.module.domain.Client;
import com.getandlook.module.dto.ClientDto;
import com.getandlook.service.interfaces.CreateService;
import com.getandlook.service.interfaces.ReadFromFileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.font.CreatedFontTracker;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Володимир Майборода on 01.11.2017.
 */

@Path("/admin/file")
@Service
public class ReadFromFileServiceImpl implements ReadFromFileService {
    private static final Logger LOG = LogManager.getLogger(ReadFromFileServiceImpl.class);

    @Autowired
    private CreateService createService;

    @POST
    @Path("/xml")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public int createClientFromXML(@FormParam("path") String path, @FormParam("userId") Integer userId) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int count = 0;

        try {
            File fXmlFile = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("client");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    Date date = dateFormat.parse(eElement.getElementsByTagName("birthDate").item(0).getTextContent());

                    createService.createClient(new ClientDto(name, date, userId).getClient());
                   count++;
                }
            }
        } catch (Exception e) {
            LOG.error(e);
        }

        return count;
    }
}
