package com.getandlook.module.image.interfaces;

import java.util.Map;

/**
 * Created by Володимир Майборода on 18.11.2017.
 */
public interface ImageProcessing {

    Map<String, Double> getEmotionFromImage(String path, String type);

}
