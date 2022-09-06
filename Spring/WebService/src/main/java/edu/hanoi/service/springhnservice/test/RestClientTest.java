package edu.hanoi.service.springhnservice.test;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RestClientTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/list/users");

        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Accept", "Application/Json");

        String account = "random15:3241";
        String basicAuth = "Basic " + DatatypeConverter.printBase64Binary(account.getBytes());
        connection.setRequestProperty("Authorization", basicAuth);

        InputStream stream = connection.getInputStream();
        byte[] bytes = new byte[4 * 1024];
        int read = -1;
        try {
            while ((read = stream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, read));
            }
        } finally {
            stream.close();
        }
    }
}
