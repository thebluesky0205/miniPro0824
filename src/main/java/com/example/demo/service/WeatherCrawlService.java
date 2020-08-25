package com.example.demo.service;

import com.example.demo.entity.Weather;
import com.example.demo.repository.WeatherRepository;
import lombok.extern.java.Log;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Lazy
@Log
public class WeatherCrawlService {
    @Autowired
    WeatherRepository weatherRepository;

    private org.jsoup.nodes.Document document;

    public Document connectUrl(String url) {
        log.info("connectUrl(): " + url);

        try {
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozila/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20100101 " +
                            "Firefox/10.0 AppleWebKit/537.36 (KHTML, like Gecko) " +
                            "Chrome/51.0.2704.103 Safari/537.36")
                    .execute();

            document = homepage.parse();
        } catch (Exception e) {
            System.out.println("Error in mainCrawler");
        }

        return document;
    }

    public List<Weather> weatherFindAll() {
        log.info("weahterFindAll()");

        return weatherRepository.findAll();
    }

//    public void crawlingHome() {
//        log.info("crawlingHome()");
//
//        weatherRepository.deleteAll();
//        document = connectUrl("https://www.weather.go.kr/w/weather/today.do#last-recent");
//
//        Elements total = document.select("div.cont-box04");
//        // Elements image = document.select("div.item_issue>a.link_thumb>img.thumb_g");
//
//        Weather weather = null;
//
//        for (int i = 0; i < total.size(); i++) {
//            weather = new Weather();
//            weather.setWeatherNo(String.valueOf(i + 1));
//            //weather.setTitle(total.get(i).text());
//            weather.setAddress(total.get(i).attr("href"));
//           // weather.setImage(image.get(i).attr("src"));
//            weatherRepository.save(weather);
//        }
//    }

    public void mainCrawler() {
        log.info("mainCrawler(): ");

        document = connectUrl("https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EC%84%9C%EC%9A%B8+%EB%82%A0%EC%94%A8&oquery=%EC%84%9C%EC%9A%B8+%EA%B5%AC%EB%B3%84+%EB%82%A0%EC%94%A8&tqi=U0K3Lwp0J1ssssgWgLossssssbG-474199");
        weatherRepository.deleteAll();

        weatherGo(document.select("li.date_info.today"));

//        document = connectUrl("https://n.weather.naver.com/today");
//        weatherRepository.deleteAll();
//
//        weatherGo(document.select("div.info_area"));
    }

    public void weatherGo(Elements elements) {
        log.info("weatherGO(): elements - " + elements );

        Weather weather = null;

        for (int i = 0; i < elements.size(); i++) {
            log.info("weatherGO");
            weather = new Weather();

            weather.setWeatherNo(String.valueOf(weatherRepository.findAll().size()+ 1));
            weather.setDday(elements.get(i).select("span.day_info>span").text());

            weather.setMimg(elements.get(i).select("span.point_time.morning>span.ico_state2.ws1").attr("src"));
            weather.setMrr(elements.get(i).select("span.point_time.morning>span.rain_rate>span.num").text());

            weather.setAimg(elements.get(i).select("span.point_time.afternoon>span").attr("src"));
            weather.setArr(elements.get(i).select("span.point_time.afternoon>span.rain_rate>span.num").text());

            weather.setTemp(elements.get(i).select("dl>dd").text());

            weather.setText(elements.get(i).select("dl>dd:nth-child(4)>ul>li:nth-child(2)>a").text());


            // weather.setImageM(elements.get(i).select("span.ico_state2.ws5").attr("src"));
            // weather.setImageA(elements.get(i).select("span.ico_state2.ws1").attr("src"));
           // weather.setAddress(elements.attr("href"));

            weatherRepository.save(weather);
        }
    }

//    public void mainCrawler() throws IOException {
//        log.info("mainCrawler(): ");
//
//        String WeatherURL = "https://weather.naver.com/today";
//        Document doc = Jsoup.connect(WeatherURL).get();
//        Elements elem = doc.select(".weather_area .summary  .weather");
//        String[] str = elem.text().split(" ");
//        System.out.println("elem = " + elem);
//        System.out.println("str = " + str);
//
//        document = connectUrl("https://www.weather.go.kr/w/weather/today.do");
//        weatherRepository.deleteAll();
//
//        weatherGO(document.select("div.container>section.page-wrap>div.right-content>div.cont-wrap"));
//    }
//
//    public void weatherGO(Elements elements) {
//        log.info("weatherGO(): elements - " + elements );
//
//        Weather weather = null;
//
//        for (int i = 0; i < elements.size(); i++) {
//            log.info("weatherGO");
//            weather = new Weather();
//
//            weather.setWeatherNo(String.valueOf(weatherRepository.findAll().size()+ 1));
//            weather.setDay(elements.get(i).select("strong").text());
//            weather.setDow("");
//            weather.setImageM(elements.get(i).select("div.weat-wrap>div>div.cell>img").attr("src"));
//            weather.setImageA("");
//            weather.setTempAm(elements.get(i).select("p.info-txt>span.tmn").text());
//            weather.setTempPm(elements.get(i).select("p.info-txt>span.tmx").text());
//            weather.setAddress("");
//
//            weatherRepository.save(weather);
//        }
//    }
}
