package com.arizon.StatisticalRestService.DTO;

import com.arizon.StatisticalRestService.Repository.CallerRepository;
import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.model.CallerJson;
import org.springframework.beans.factory.annotation.Autowired;

public class CallerTranslator {

    @Autowired
    CallerRepository callerRepo;

    public Caller callerJsonToCaller(CallerJson jsonObj) {
        Caller caller = new Caller();

        caller.setCallerName(jsonObj.getCallerName());
        caller.setCallerAddress(jsonObj.getCallerAddress());
        caller.setEntityTypes(jsonObj.getEntityTypes());

        return caller;
    }

    public CallerJson callerToCallerJson(Caller caller) {
        CallerJson jsonObj = new CallerJson();

        jsonObj.setCallerName(caller.getCallerName());
        jsonObj.setCallerAddress(caller.getCallerAddress());
        jsonObj.setCallerName(caller.getCallerName());

        return jsonObj;
    }
}
