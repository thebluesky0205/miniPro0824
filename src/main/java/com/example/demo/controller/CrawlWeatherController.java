package com.example.demo.controller;

import com.example.demo.entity.Weather;
import com.example.demo.service.WeatherCrawlService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Log
@RestController
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CrawlWeatherController {
    @Autowired
    WeatherCrawlService weatherCrawler;

    @GetMapping("weather")
    public List<Weather> crawling() throws IOException {
        log.info("crawling(): ");

        weatherCrawler.mainCrawler();
        return weatherCrawler.weatherFindAll();
    }
}

