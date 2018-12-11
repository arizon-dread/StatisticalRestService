package com.arizon.StatisticalRestService.controller;

import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.util.HMACHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arizon on 12/7/17.
 */
@RestController
public class SaveData {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/saveData", method = RequestMethod.POST, consumes = "application/json")
    public void saveStatisticalEntities(@RequestParam(value="HMAChash") String hmacHash, @RequestParam(value="caller") String caller,
                                        @RequestBody List<StatisticalEntity> payload) {
        boolean validCall = false;
        //TODO: get raw json message from payload
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            String jsonPayload = writer.writeValueAsString(payload);
            validCall = HMACHelper.verifyHmac(jsonPayload, hmacHash, caller);
        } catch (JsonProcessingException e) {
            log.error(""+e.getStackTrace());
        }

    }
}
