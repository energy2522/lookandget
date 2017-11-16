package com.getandlook;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by Володимир Майборода on 20.10.2017.
 */

public class MyApplication extends ResourceConfig {

    public MyApplication() {
        packages("com.getandlook");
    }
}
