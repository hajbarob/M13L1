import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HabrJsoupTest {

    public static void main(String[] args) throws IOException {
        String url = "https://habr.com/ru/amp/publications/483202/";

        //Document вннутр класс jsoup - представлення веб сторінки
        Document document = Jsoup.connect(url).get();

        Element body = document.body();
        String text = body.text();

        Element head = document.getElementsByTag("head").first();
        Element title = head.getElementsByTag("title").first();

        Element element = document.selectFirst("div.tm-article__tags");

        System.out.println("document.selectFirst(\"a.tm-user-card__nickname\").text() = "
                + document.selectFirst("a.tm-user-card__nickname").text());

        System.out.println("title.text() = " + title.text());

    }
}
