package org.example.new_approach.bfs.web_crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFS {


    private Queue<String> queue;
    private List<String> discoverableWebsiteList;


    public BFS(){
        this.queue = new LinkedList<>();
        this.discoverableWebsiteList = new ArrayList<>();
    }

    public void discoverWeb(String root){

        this.queue.add(root);
        this.discoverableWebsiteList
                .add(root);

        while(!queue.isEmpty()){

            String v = this.queue.remove();
            String rawHtml = readUrl(v);

            String regexp = "https://(\\w+\\.)+(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(rawHtml);
            while (matcher.find()) {

                String w = matcher.group();
                if(!discoverableWebsiteList.contains(w)){
                    discoverableWebsiteList.add(w);
                    System.out.println("website found: " + w);
                    queue.add(w);
                }

            }
        }
    }


    private String readUrl(String url){

        StringBuilder rawHtml = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlObj.openStream())
            );

            String line ="";

            while((line = reader.readLine()) != null){
                rawHtml.append(line);
            }
            reader.close();




        } catch (MalformedURLException e) {
            System.out.println("Malformed URL" +e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error" +e.getMessage());
        }

        return rawHtml.toString();

    }
}
