package com.github.pavelkv96.hw_16102017.http;

/**
 * Created by Pavel on 25.10.2017.
 */

public interface IHttpClient {
    void request(String url, HttpClient.IResponseListener listener);
}
