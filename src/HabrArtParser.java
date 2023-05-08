import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HabrArtParser {

    private Element article;

    public HabrArtParser(Element article) {
        this.article = article;
    }

    public String getTitle() {
        return article.getElementsByTag("h2").first().text();
    }

    public int getRate() {
        String text = article.selectFirst("span.tm-votes-meter__value").text();
        return Integer.valueOf(text);
    }
}
