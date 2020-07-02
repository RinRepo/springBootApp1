package com.lessons.config;

import org.asynchttpclient.AsyncHttpClient;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Configuration
public class HttpClientConfig {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientConfig.class);

    @Bean
    public AsyncHttpClient asyncHttpClient()
    {
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        logger.debug("New asyncHttpClient create. Default read timeout: {}", asyncHttpClient.getConfig().getReadTimeout());
        logger.debug("New asyncHttpClient create. Default read timeout: {}", asyncHttpClient.getConfig().getRequestTimeout());
        return asyncHttpClient();

    }

    public HttpClientConfig() {
        logger.debug("HttpClientConfig Constructor Called");
    }

}