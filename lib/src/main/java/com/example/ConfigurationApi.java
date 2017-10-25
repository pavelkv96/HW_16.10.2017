package com.example;

/**
 * Created by Pavel on 25.10.2017.
 */

public class ConfigurationApi {
    private static final String ADDITIONAL_URL = "config.json";

    private String mBasePath;

    public ConfigurationApi(final String pBasePath) {
        if (pBasePath.charAt(pBasePath.length() - 1) == '/') {
            mBasePath = pBasePath;
        } else {
            mBasePath = pBasePath + "/";
        }
        mBasePath = pBasePath;
    }

    public String getUrl() {
        return mBasePath + ADDITIONAL_URL;
    }
}
