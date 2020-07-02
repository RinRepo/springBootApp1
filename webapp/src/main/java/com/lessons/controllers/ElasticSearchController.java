package com.lessons.controllers;

import com.lessons.models.SearchDTO;
import com.lessons.models.ShortReportDTO;
import com.lessons.services.ElasticSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ElasticSearchController {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchController.class);
    @Resource
    private ElasticSearchService elasticSearchService;

    @RequestMapping(value="/api/search_old", method= RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> runSearchOld() throws Exception {
        logger.debug("getShortReports() started.");

        String json=  elasticSearchService.runSearch("run",null);


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }

    @RequestMapping(value="/api/search", method= RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> runSearch(@RequestBody SearchDTO searchDTO) throws Exception {
        logger.debug("getShortReports() started.");

        String json=  elasticSearchService.runSearch(searchDTO.getRawQuery(), searchDTO.getFilters());


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(json);
    }
}

