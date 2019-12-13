package com.arizon.StatisticalRestService.DTO;
import com.arizon.StatisticalRestService.Repository.CallerRepository;
import com.arizon.StatisticalRestService.Repository.EntityTypeRepository;
import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import model.StatisticalEntityJson;

import java.util.Optional;

@Component
public class StatisticalEntityTranslator {

    @Autowired
    private CallerRepository callerRepo;
    @Autowired
    private EntityTypeRepository entityTypeRepository;
    public StatisticalEntityTranslator() {}

    public StatisticalEntity getStatisticalEntityFromJson(StatisticalEntityJson jsonObj, long callerId) {
        StatisticalEntity statEntity = new StatisticalEntity();
        Optional<Caller> oCaller = callerRepo.findById(callerId);

        statEntity.setCaller(oCaller.get());
        statEntity.setEntitytype(new EntityType(jsonObj.getEntityType()));
        statEntity.setOccurances(jsonObj.getOccurances());
        statEntity.setTimeStamp(jsonObj.getTimeStamp());
        statEntity.setValue(jsonObj.getValue());
        return statEntity;
    }
    public StatisticalEntityJson getStatisticalEntityJsonFromDbObj(StatisticalEntity dbEntity) {
        StatisticalEntityJson jsonObj = new StatisticalEntityJson();

        jsonObj.setEntityType(dbEntity.getEntitytype().getUnit());
        jsonObj.setTimeStamp(dbEntity.getTimeStamp());
        jsonObj.setOccurances(dbEntity.getOccurances());
        jsonObj.setValue(dbEntity.getValue());

        return jsonObj;
    }
}
