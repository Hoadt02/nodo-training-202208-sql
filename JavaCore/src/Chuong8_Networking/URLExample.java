package Chuong8_Networking;

import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {
    public static void main(String[] args) throws MalformedURLException {;
        String link = "https://www.google.com/search?q=hello&sxsrf=ALiCzsYC1SlELGACOhxX-PGN0kXYrTpOKg%3A1661134497060&source=hp&ei=oeYCY8V58cmYBabhnKgL&iflsig=AJiK0e8AAAAAYwL0sejnzqw-pzMox1UPkuvm35gFPeu7&ved=0ahUKEwiFzvmcsNn5AhXxJKYKHaYwB7UQ4dUDCAc&uact=5&oq=hello&gs_lcp=Cgdnd3Mtd2l6EAMyBAgAEEMyBAgAEEMyBAgAEEMyCgguELEDENQCEEMyCgguELEDENQCEEMyCAguEIAEELEDMggIABCABBCxAzIICAAQgAQQsQMyCwguEIAEELEDEIMBMgoILhDHARDRAxBDOgcIIxDqAhAnOg0ILhDHARDRAxDqAhAnOgQIIxAnOggIABCxAxCDAToOCC4QgAQQsQMQgwEQ1AI6CwgAEIAEELEDEIMBOgUILhCABDoHCAAQsQMQQzoFCAAQgAQ6CwguEIAEEMcBEK8BOggILhCxAxCDAToECC4QAzoLCC4QgAQQsQMQ1AI6EQguEIAEELEDEIMBEMcBENEDOggILhCABBDUAjoECC4QQ1CHBlipGWCdHGgDcAB4AIABf4gB3QaSAQMwLjeYAQCgAQGwAQo&sclient=gws-wiz";
        URL url = new URL(link);

        System.out.println("Protocol " + url.getProtocol());
        System.out.println("Port " + url.getPort());
        System.out.println("Query " + url.getQuery());
    }
}
