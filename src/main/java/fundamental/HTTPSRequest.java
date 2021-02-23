package main.java.fundamental;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.*;
/**
 * @author YC (shell845)
 * @date 13/2/2021 6:39 PM
 */

public class HTTPSRequest {
    private static TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
    };

    public static void main(String[] args) throws Exception {
        // Install the all-trusting trust manager
        SSLContext sc = null;
        HttpClient httpClient = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // add sslcontext
            httpClient = HttpClient.newBuilder().sslContext(sc).build();
        } catch (Exception e) {
            //
        }

        if (sc == null || httpClient == null) {
            System.err.println("Init error");
            System.exit(0);
        }

        String url = "https://www.google.com/";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                    .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
                    .timeout(Duration.ofSeconds(5))
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Request: " + response.request());
        Map<String, List<String>> headers = response.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }
        System.out.println(response.body().substring(0, 1024) + "...");
    }
}
