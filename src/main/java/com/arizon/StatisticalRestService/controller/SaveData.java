package com.arizon.StatisticalRestService.controller;

import com.arizon.StatisticalRestService.DTO.StatisticalEntityTranslator;
import com.arizon.StatisticalRestService.Repository.CallerRepository;
import com.arizon.StatisticalRestService.Repository.StatisticalEntityRepository;
import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import com.arizon.StatisticalRestService.service.PersistenceService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by arizon on 12/7/17.
 */


@Api(tags = "SaveData")
@RestController
public class SaveData {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CallerRepository callerRepo;

    @Autowired
    StatisticalEntityRepository statEntityRepo;

    @Autowired
    StatisticalEntityTranslator statEntityTranslator;
    @Autowired
    PersistenceService persistenceService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/saveData", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> saveStatisticalEntities(@RequestParam(value = "callerId", required = false) long callerId,
                                                          @RequestParam(value = "callerName", required = false) String callerName,
                                                          @RequestBody StatisticalEntityJson[] payload) {
        //TODO: verify caller
        Long callerIdValue = callerId;
        if (callerIdValue == null && StringUtils.isEmpty(callerName)) {
            return new ResponseEntity<String>("Missing request parameter, callerId or callerName", HttpStatus.BAD_REQUEST);
        }
        boolean persisted = false;

        Caller caller;

        //if the callerIndication is byId, we persist with this method.
        if (callerIdValue != null) {
            Optional<Caller> optionalCaller = callerRepo.findById(callerId);
            caller = optionalCaller.get();

            if (!StringUtils.isEmpty(caller.getCallerName())) {
                persisted = persistEntity(payload, caller);
            }

        } else if (!StringUtils.isEmpty(callerName)) {
            caller = callerRepo.findByCallerName(callerName.toLowerCase());
            if (caller.getCallerName().equals(callerName.toLowerCase())) {
                persisted = persistEntity(payload, caller);
            }
        }
        if (persisted) {
            return new ResponseEntity<String>("Persistence successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Persistence failed", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    private boolean persistEntity(StatisticalEntityJson[] entities, Caller caller) {
        boolean persisted = false;
        for (int i = 0; i < entities.length; i++) {
            StatisticalEntity dbEntity = statEntityTranslator.getStatisticalEntityFromJson(entities[i], caller.getCallerId());
            if (statEntityRepo.existsById(dbEntity.getId())) {
                persistenceService.merge(dbEntity);
                persisted = true;
            } else {
                persistenceService.persist(dbEntity);
                persisted = true;
            }
        }
        return persisted;
    }

}
