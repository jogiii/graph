package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;


public class WebCrawlerBFS {

    private Set<String> visitedUrls = new HashSet<>();
    private Queue<String> queue = new LinkedList<>();

    public void crawl(String startUrl,int maxPages) {
        queue.add(startUrl);
        visitedUrls.add(startUrl);
        while (!queue.isEmpty() && visitedUrls.size() < maxPages) {
            String url = queue.poll();
            System.out.println("Crawling " + url);

            List<String> newUrls = getLinks(url);
            for(String link : newUrls) {
                if(!visitedUrls.contains(link) && visitedUrls.size() <maxPages) {
                    visitedUrls.add(link);
                    queue.add(link);

                }
            }
        }
    }

    private List<String> getLinks(String url) {
        List<String> links = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a[href]"); // Extract hyperlinks

            for (Element element : elements) {
                String absUrl = element.absUrl("href"); // Get absolute URL
                if (isValidUrl(absUrl)) {
                    links.add(absUrl);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to fetch: " + url);
        }
        return links;
    }

    private boolean isValidUrl(String url) {
        return url.startsWith("http") && !url.contains("#");
    }

    public static void main(String[] args) {
        WebCrawlerBFS crawler = new WebCrawlerBFS();
        String startUrl = "https://www.youtube.com/watch?v=7fujbpJ0LB4&t=224s"; // Change this to a real website
        int maxPages = 10; // Limit number of pages
        crawler.crawl(startUrl, maxPages);
    }






}
