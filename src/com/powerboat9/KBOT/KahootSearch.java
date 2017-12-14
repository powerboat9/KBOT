package com.powerboat9.KBOT;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class KahootSearch {
    private HttpClient httpClient;

    private KahootSearch() throws Exception {
        httpClient = new HttpClient(new SslContextFactory());
        httpClient.start();
    }

    public static KahootSearch getInstance() {
        try {
            return new KahootSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean check(int id)  {
        try {
            System.out.println(httpClient.GET("https://kahoot.it/reserve/session/" + id).getStatus());
            /*con.connect();
            if (con.getResponseCode() < 300) {
                byte[] buff = new byte[4096];
                int in;
                InputStream inStream = (InputStream) con.getContent();
                while ((in = inStream.read(buff)) != -1) {
                    System.out.write(buff, 0, in);
                }
                return true;
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return false;
    }
}
