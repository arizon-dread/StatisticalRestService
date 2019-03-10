package com.arizon.StatisticalRestService.controller;

import com.arizon.StatisticalRestService.DTO.StatisticalEntityJsonToStatisticalEntity;
import com.arizon.StatisticalRestService.Repository.CallerRepository;
import com.arizon.StatisticalRestService.Repository.StatisticalEntityRepository;
import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import com.arizon.StatisticalRestService.util.HMACHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Created by arizon on 12/7/17.
 */
@RestController
public class SaveData {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    @Autowired
    CallerRepository callerRepo;

    @Autowired
    StatisticalEntityRepository statEntityRepo;

    @Autowired
    StatisticalEntityJsonToStatisticalEntity statEntityTranslator;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/saveData", method = RequestMethod.POST, consumes = "application/json")
    public void saveStatisticalEntities(@RequestParam(value="caller") Long callerId,
                                        @RequestBody List<StatisticalEntityJson> payload) {
        //TODO: verify caller

        Optional<Caller> optionalCaller  = callerRepo.findById(callerId);
        Caller caller = optionalCaller.get();
        if (caller.getCallerName() != null) {
            //TODO: Save payload
            for (StatisticalEntityJson jsonEntity : payload) {
                StatisticalEntity dbEntity = statEntityTranslator.getStatisticalEntityFromJson(jsonEntity);
                if(statEntityRepo.existsById(dbEntity.getId())) {
                    entityManager.merge(dbEntity);
                } else {
                    entityManager.persist(dbEntity);
                }
            }
        }








        //        boolean validCall = false;
        //TODO: get raw json message from payload
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
//        try {
//            String jsonPayload = writer.writeValueAsString(payload);
//            //validCall = HMACHelper.verifyHmac(jsonPayload, hmacHash, caller);
//        } catch (JsonProcessingException e) {
//            log.error(""+e.getStackTrace());
//        }

    }
}
