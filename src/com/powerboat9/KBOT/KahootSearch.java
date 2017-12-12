package com.powerboat9.KBOT;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;

public class KahootSearch {
    public static boolean check(int id) {
        try {
            URL url = new URL("https://kahoot.it/reserve/session/" + id);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            return con.getResponseCode() < 300;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
