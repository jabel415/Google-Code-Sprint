package com.example.jabel.smartevents;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.jayway.jsonpath.JsonPath;

import net.minidev.json.parser.JSONParser;

import org.json.*;
import java.io.FileInputStream;
import java.util.Properties;

/** Example of Java client calling Knowledge Graph Search API */
public class SearchExample {
    public static Properties properties = new Properties();
    //private String API_KEY = "AIzaSyCLXfY4Y1Aiy8Wl22YjMD2DWfwNiCrEo5Q"
    public static void main(String[] args) {
        try {
            properties.load(new FileInputStream("kgsearch.properties"));

            HttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            JSONParser parser = new JSONParser();
            GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
            url.put("query", "Taylor Swift");
            url.put("limit", "10");
            url.put("indent", "true");
            url.put("key", properties.get("API_KEY"));
            HttpRequest request = requestFactory.buildGetRequest(url);
            HttpResponse httpResponse = request.execute();
            JSONObject response = (JSONObject) parser.parse(httpResponse.parseAsString());
            JSONArray elements = (JSONArray) response.get("itemListElement");
            /*for (Object element : elements) {
                System.out.println(JsonPath.read(element, "$.result.name").toString());
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}