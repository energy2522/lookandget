package com.lookandget;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Володимир Майборода on 12.12.2017.
 */

public class StaticConstant {
    public static List<String> DUMMY_CREDENTIALS = new ArrayList<>();

    static {
        DUMMY_CREDENTIALS.add("energy2522:snaiper5");
        DUMMY_CREDENTIALS.add("admin:admin");
    }


}
