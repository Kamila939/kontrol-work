package ru.itis.client;

import java.net.URL;
import java.util.List;
import java.util.Map;

public interface HttpClient {

    /**
     * Sending POST request to specified URL
     * @param url specified URL
     * @param headers specified headers
     * @param body body of the request
     * @return Response body as String
     */
    String sendPost(URL url, Map<String, List<String>> headers, String body);
    /**
     * Sending GET request to specified URL
     * @param url specified URL
     * @param headers specified headers
     * @return Response body as String
     */
    String sendGet(URL url, Map<String, List<String>> headers);
    /**
     * Sending PUT request to specified URL
     * @param url specified URL
     * @param headers specified headers
     * @param body body of the request
     * @return Response body as String
     */
    String sendPut(URL url, Map<String, List<String>> headers, String body);
    /**
     * Sending DELETE request to specified URL
     * @param url specified URL
     * @param headers specified headers
     * @return Response body as String
     */
    String sendDelete(URL url, Map<String, List<String>> headers);
    /**
     * Sending HEAD request to specified URL
     * @param url specified URL
     * @param headers specified headers
     * @return Response headers as String
     */
    String sendHead(URL url, Map<String, List<String>> headers);
}
