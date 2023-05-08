import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrArtParserTest {
    public static void main(String[] args) throws IOException {
        String url = "https://habr.com/ru/all/";

        Document document = Jsoup.connect(url).get();

        Elements articles = document.selectFirst("div.tm-articles-list")
                .select("article");

        for (Element art : articles) {
            HabrArtParser habrArtParser = new HabrArtParser(art);

            String title = habrArtParser.getTitle();
            int rate = habrArtParser.getRate();

            System.out.println("rate = " + rate + " title = " + title);
        }
    }
}
