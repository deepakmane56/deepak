package mycrawler;
  
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MyWebCrawling {

    private HashSet<String> links;

    public MyWebCrawling() {
        links = new HashSet<String>();
    }

    public void getPageLinks(String URL) {
        //Check to see if url already exists
        if (!links.contains(URL)) {
            try {
                //adding url, if not exists
                if (links.add(URL)) {
                    //System.out.println(URL);
                }

                //get url and fetch HTML code
                Document document = Jsoup.connect(URL).get();
                //store the nested links from the current URLs
                Elements linksOnPage = document.select("a[href]");
                //System.out.println("deepak " + linksOnPage);
                
//Element linksOnPage = document.select("a").first();
//String linkHref = linksOnPage.attr("href");
//String linkTitle = linksOnPage.attr("title");
//System.out.println("linkHref " + linkHref);;
//System.out.println("linkTitle " + linkTitle); 

                
                //extract URL
                for (Element page : linksOnPage) {
                    getPageLinks(page.attr("abs:href"));
                    //System.out.println("deepak " + page);
                    //System.out.println(page.attr("abs:href"));
                    //System.out.println(page.attr("title"));
                    //System.out.println();
                    
                    // set the values in pojo
                    MyJSON myJSON = new MyJSON();
                    String url = page.attr("abs:href");
                    String title = page.attr("title");
                    String node = "deep"; //page.attr("deepak");
                    myJSON.setUrl(url);
                    myJSON.setTitle(title);
                    myJSON.setNodes("");
                    //System.out.println(myJSON.toString());
                    
                    ObjectMapper mapperObj = new ObjectMapper();
                    try {
                        // get Employee object as a json string
                        String jsonStr = mapperObj.writeValueAsString(myJSON);
                        System.out.println(jsonStr);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }                    
                    
                    
                }// end of for loop
                
                
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        //initial url
        new MyWebCrawling().getPageLinks("http://www.google.com/");
    }

}