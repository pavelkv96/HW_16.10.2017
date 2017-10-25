package com.github.pavelkv96.hw_16102017;

import com.example.Configuration;
import com.example.ConfigurationApi;
import com.github.pavelkv96.hw_16102017.http.HttpClient;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Pavel on 25.10.2017.
 */

class VersionChecker {

    private Configuration mConfiguration;

    VersionChecker() {
        final String url = new ConfigurationApi(BuildConfig.BASE_CHECKER_URL).getUrl();
        final ConfigurationResponseListener listener = new ConfigurationResponseListener();
        new HttpClient().request(url, listener);
        mConfiguration = listener.getConfiguration();
    }

    Boolean isCorrectVersion() {
        return mConfiguration.getVersion() <= BuildConfig.VERSION_CODE;
    }

    Boolean isForceUpdate() {
        return mConfiguration.getUpdate();
    }


    private static class ConfigurationResponseListener implements HttpClient.IResponseListener {

        private Configuration mConfiguration;
        private Throwable mThrowable;

        @Override
        public void onResponse(final InputStream pInputStream) {
            InputStreamReader inputStreamReader = null;
            try {
                inputStreamReader = new InputStreamReader(pInputStream);
                mConfiguration = new GsonBuilder()
                        .setLenient()
                        .create()
                        .fromJson(inputStreamReader, Configuration.class);
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (final Exception e) {
                        e.getMessage();
                    }
                }
            }
        }

        public Throwable getThrowable() {
            return mThrowable;
        }

        Configuration getConfiguration() {
            return mConfiguration;
        }
    }
}