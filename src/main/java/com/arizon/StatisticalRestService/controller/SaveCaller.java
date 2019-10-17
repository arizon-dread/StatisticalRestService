package com.arizon.StatisticalRestService.controller;

import com.arizon.StatisticalRestService.Repository.CallerRepository;
import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.service.PersistenceService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SaveCaller")
@RestController
@RequestMapping("/")
public class SaveCaller {

    @Autowired
    CallerRepository callerRepo;

    @Autowired
    PersistenceService persistenceService;
    public SaveCaller() {}

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(name = "/addCaller", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String>  addCaller(@RequestBody Caller caller) {

        try {

            if (callerRepo.findById(caller.getCallerId()) == null) {
                persistenceService.persist(caller);
                return new ResponseEntity<String>("Caller saved", HttpStatus.OK);
            } else {
                persistenceService.merge(caller);
                return new ResponseEntity<String>("Caller saved", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>("Saving caller failed. ", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }






}
