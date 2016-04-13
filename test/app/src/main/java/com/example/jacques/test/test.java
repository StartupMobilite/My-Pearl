package com.example.jacques.test;

/**
 * Created by jacques on 05/04/2016.
 */
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by houdaelmaaroufi on 05/04/16.
 */
public class test {

    public static final String strURL = "http://comparateur.esy.es/test1.php";

    public String getServerData(String returnString) throws  ConnectException {
        StringBuilder content = new StringBuilder();
        try {
             URL url = new URL("http://comparateur.esy.es/test1.php"); // creer un obj url
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //creer un obj conn
            connection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line + "\n");
                Log.v("HttpConnection", "read =" + br.toString());

                System.out.println(" Error");
                String  texte = (String) url.getContent();

                System.out.println(texte);
            }
        } catch (ConnectException e) {
            e.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();

        }
        return  content.toString();
    }
}