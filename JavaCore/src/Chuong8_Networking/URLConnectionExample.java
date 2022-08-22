package Chuong8_Networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String[] args) throws IOException {
        String url_test = "https://translate.google.com/?sl=en&tl=vi&text=offset&op=translate";
        URL url = new URL(url_test);

        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();

        int read = 0;
        byte[] bytes = new byte[10];
        while ((read = stream.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, read));
        }
    }
}
