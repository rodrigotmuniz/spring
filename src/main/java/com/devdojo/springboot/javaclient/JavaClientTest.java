/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.javaclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author rodrigo.muniz
 */
public class JavaClientTest {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String username = "kuwabara";
        String password = "123456";
        try {
            URL url = new URL("http://localhost:8080/v1/user/students/3");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            System.out.println(encodeUsernamePassaword(username, password));
            connection.addRequestProperty("Authorization", "Basic " + encodeUsernamePassaword(username, password));
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSB = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                jsonSB.append(line);
                line = reader.readLine();
            }
            System.out.println(jsonSB.toString());
            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
            if(connection != null) {
                connection.disconnect();
            }
        }
    }
    
    private static String encodeUsernamePassaword(String username, String password) {
        String usernamePassword = username + ":" + password;
        return Base64.encodeBase64String(usernamePassword.getBytes());
    }
}
