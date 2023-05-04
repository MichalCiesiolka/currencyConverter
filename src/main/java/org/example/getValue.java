package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class getValue {
    public static double getCurrValue(String from, String to) throws IOException {
        String url = "https://www.google.com/search?q="+ from + to;
        Document doc = Jsoup.connect(url).get();
        String value = null;
        for (Element e : doc.select("span.DFlfde.SwHCTb")){
            value = e.text();
        }

        if (value == null)
            System.out.println("error");
        else
            return (currToDouble(value));
        return 0;
    }

    public static double currToDouble(String valString) {
        String valueOfCurrencyinString = valString.replace(',','.');
        return(Double.parseDouble(valueOfCurrencyinString));
    }

}
