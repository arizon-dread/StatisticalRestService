package com.arizon.StatisticalRestService.DTO;
import com.arizon.StatisticalRestService.Repository.EntityTypeRepository;
import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticalEntityJsonToStatisticalEntity {


    @Autowired
    private EntityTypeRepository entityTypeRepository;
    public StatisticalEntityJsonToStatisticalEntity() {}

    public StatisticalEntity getStatisticalEntityFromJson(StatisticalEntityJson jsonObj, long callerId) {
        StatisticalEntity statEntity = new StatisticalEntity();

        statEntity.setCaller(callerId);
        statEntity.setEntitytype(new EntityType(jsonObj.getEntityType()));
        statEntity.setOccurances(jsonObj.getOccurances());
        statEntity.setTimeStamp(jsonObj.getTimeStamp());

        return statEntity;
    }
    public StatisticalEntityJson getStatisticalEntityJsonFromDbObj(StatisticalEntity dbEntity) {
        StatisticalEntityJson jsonObj = new StatisticalEntityJson();

        jsonObj.setEntityType(dbEntity.getEntitytype().getUnit());
        jsonObj.setTimeStamp(dbEntity.getTimeStamp());
        jsonObj.setOccurances(dbEntity.getOccurances());

        return jsonObj;
    }
}
