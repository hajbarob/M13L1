package privatBank;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CurrencyParser {

    public static void main(String[] args) throws IOException {
        String input = "EUR";

        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        String json = Jsoup.connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type type = TypeToken.getParameterized(List.class, CurrencyItemDto.class)
                .getType();

        List<CurrencyItemDto> items = new Gson().fromJson(json, type);

        Float aFloat = items.stream()
                .filter(it -> it.getCcy() == CurrencyItemDto.CCY.valueOf(input))
                .filter(it -> it.getBase_ccy() == CurrencyItemDto.CCY.UAH)
                .map(it -> it.getBuy())
                .findFirst()
                .orElseThrow();

        System.out.println("UAH/" + input + " buy course = " + aFloat);
    }
}
