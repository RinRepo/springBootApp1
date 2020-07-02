package com.lessons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.lessons.models.ShortReportDTO;
import com.lessons.services.ReportService;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.asynchttpclient.Response;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.util.StringBuilderPool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddTestRecordsToES
{
    private static final Logger logger = LoggerFactory.getLogger(AddTestRecords.class);


    @Test
    public void insertTestRecords()
    {
        logger.debug("inside test method");
        String jsonToInsert = "{\"index\": {\"_index\": \"reports\", \"_type\": \"record\"}}\n" +
                "{\"priority\" : \"low\", \"actors\": \"john Smith\", \"description\": \"he likes it\", \"id\": \"1\", \"ip\": \"1.1.1.1\", \"created_date\": \"2010-09-27\", \"is_completed\": true, \"country\": \"China\"}\n";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);


        ReportService reportService = new ReportService();
        List<ShortReportDTO> listOfAllReportsShort = reportService.getAllShortReports2();

        StringBuilder sb = new StringBuilder();
        for (ShortReportDTO currentReport : listOfAllReportsShort)
        {
            String jsonLine1 = "{\"index\": {\"_index\": \"reports\", \"_type\": \"record\"}}\n";
            String jsonLine2 = "{\"priority\" : \"low\", \"actors\": \"john Smith\", \"description\": \"he likes it\", \"id\": \"1\", \"ip\": \"1.1.1.1\", \"created_date\": \"2010-09-27\", \"is_completed\": true, \"country\": \"China\"}\n";
            sb.append(jsonLine1);
            sb.append(jsonLine2);
        }

//        String jsonRequest = sb.toString();
//
        Response response = AsyncHttpClient.preparePost(url);
//                .setHeader( name: "accept", value: )


        String jsonResponse = response.getResponseBody();
        Map<String, Object> responseMap = objectMapper.readValue(jsonResponse, tr);
        TypeReference tr = new TypeReference<Map<String,Object>>(){};
        boolean checkIfErrorDuringInsert = (boolean) mapOfJsonResponse.get("errors");
    }
}

