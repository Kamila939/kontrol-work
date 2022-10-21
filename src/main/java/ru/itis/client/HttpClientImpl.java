package ru.itis.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpClientImpl implements HttpClient {

    @Override
    public String sendPost(URL url, Map<String, List<String>> headers, String body) {
        StringBuilder content = new StringBuilder();
        try {
            HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();

            postConnection.setRequestMethod("POST");

            setHeaders(headers, postConnection);

            postConnection.setDoOutput(true);

            try (OutputStream outputStream = postConnection.getOutputStream()) {
                byte[] input = body.getBytes();
                outputStream.write(input, 0, input.length);
            }

//            System.out.println(postConnection.getResponseCode());

            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(postConnection.getInputStream())
                         )) {
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    @Override
    public String sendGet(URL url, Map<String, List<String>> headers) {
        StringBuilder content = new StringBuilder();
        try {
            HttpURLConnection getConnection = (HttpURLConnection) url.openConnection();

            setHeaders(headers, getConnection);

            getConnection.setDoOutput(true);


            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(getConnection.getInputStream())
                         )) {
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    @Override
    public String sendPut(URL url, Map<String, List<String>> headers, String body) {
        StringBuilder content = new StringBuilder();
        try {
            HttpURLConnection putConnection = (HttpURLConnection) url.openConnection();
            putConnection.setRequestMethod("PUT");

            setHeaders(headers, putConnection);

            putConnection.setDoOutput(true);

            try (OutputStream outputStream = putConnection.getOutputStream()) {
                byte[] input = body.getBytes();
                outputStream.write(input, 0, input.length);
            }

            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(putConnection.getInputStream())
                         )) {
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    @Override
    public String sendDelete(URL url, Map<String, List<String>> headers) {
        StringBuilder content = new StringBuilder();
        try {
            HttpURLConnection deleteConnection = (HttpURLConnection) url.openConnection();

            deleteConnection.setRequestMethod("DELETE");

            setHeaders(headers, deleteConnection);

            deleteConnection.setDoOutput(true);

            try (BufferedReader reader =
                         new BufferedReader(
                                 new InputStreamReader(deleteConnection.getInputStream())
                         )) {
                String input;
                while ((input = reader.readLine()) != null) {
                    content.append(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    @Override
    public String sendHead(URL url, Map<String, List<String>> headers) {
        Map<String, List<String>> headersMap;
        try {
            HttpURLConnection headConnection = (HttpURLConnection) url.openConnection();

            headConnection.setRequestMethod("HEAD");

            setHeaders(headers, headConnection);

            headConnection.setDoOutput(true);

            headersMap = headConnection.getHeaderFields();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return headersMap.toString();
    }

    private void setHeaders(Map<String, List<String>> headers, HttpURLConnection connection) {
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), String.join(", ", entry.getValue()));
            }
        }
    }
}
