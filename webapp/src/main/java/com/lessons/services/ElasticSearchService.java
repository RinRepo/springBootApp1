package com.lessons.services;

import org.asynchttpclient.AsyncHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElasticSearchService {
    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchService.class);

    @Value("${es.url}")
    private String esUrl;

    @Resource
    private AsyncHttpClient asyncHttpClient;

    public ElasticSearchService(){
        logger.debug("ElasticSearchService Constructor called");
    }
//
    public String runSearch(String rawQuery, List<String>filters) throws Exception {
        return "stuff";
    }
//
//        String jsonRequest="";
//
//        if (obj == null || obj.size() == 0) {
//
//            // The list is null or empty
//        }
//        else {
//            // The list has stuff
//        }
//
//
//         jsonRequest = "{\n" +
//                "    \"query\": {\n" +
//                "        \"query_string\": {\n" +
//                "           \"query\": \""+rawQuery+"\"\n" +
//                "        }\n" +
//                "    }\n" +
//                "}\n";
//
//        Response response = asyncHttpClient.preparePost(  esUrl + "/reports/_search?pretty=true")
//                .setHeader(  "accept", "application/json")
//                .setHeader(  "Content-Type", "application/json")
//                .setBody(jsonRequest)
//                .execute()
//                .get();
//        String result = response.getResponseBody();
//
//        return result;
//    }

//        public String json(SearchDTO searchDTO)
//        {
//             String json =
//        }


}
