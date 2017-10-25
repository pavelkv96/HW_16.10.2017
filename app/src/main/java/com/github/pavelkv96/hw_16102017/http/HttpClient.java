package com.github.pavelkv96.hw_16102017.http;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Pavel on 25.10.2017.
 */

public class HttpClient implements IHttpClient {
    @Override
    public void request(final String url, final IResponseListener listener) {
        try {
            final HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
            final InputStream inputStream = connection.getInputStream();
            listener.onResponse(inputStream);
            connection.disconnect();
        } catch (final Throwable throwable) {
            throwable.getMessage();
        }
    }

    public interface IResponseListener {
        void onResponse(InputStream pInputStream);
    }
}
