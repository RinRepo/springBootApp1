package com.lessons.services;

import com.google.gson.Gson;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Class to check the status of ElasticSearch upon startup
 */
@Service("com.lessons.service.HealthCheckService")
public class HealthCheckService {
    private static final Logger logger = LoggerFactory.getLogger(HealthCheckService.class);
        Gson gson = new Gson();

        @Resource
        private AsyncHttpClient asyncHttpClient;

        //@Value("${es.url}")
        private String esUrl;

        public boolean doAllMappingsExist() throws Exception{
            logger.debug("doAllMappingsExist() called");

            String jsonRequest = "";

            Response response = asyncHttpClient.preparePost(esUrl)
                    .setHeader("accept", "application/json")
                    .setHeader("Content-Type", "application/json")
                    .setBody(jsonRequest)
                    .setRequestTimeout(60000)
                    .setReadTimeout(90000)
                    .execute()
                    .get();


            return true;
        }
    }
