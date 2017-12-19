package com.getandlook.service.interfaces;

import com.getandlook.module.ImageReq;
import com.getandlook.module.ImageRequest;

import javax.ws.rs.core.Response;

/**
 * Created by Володимир Майборода on 31.10.2017.
 */

public interface ImageService {

    Response getEmotionFromPhoto(ImageReq request);
}
