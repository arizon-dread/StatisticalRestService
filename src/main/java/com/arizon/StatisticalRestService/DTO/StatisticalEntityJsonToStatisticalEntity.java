package com.arizon.StatisticalRestService.DTO;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StatisticalEntityJsonToStatisticalEntity {


    public StatisticalEntityJsonToStatisticalEntity() {}

    public StatisticalEntity getStatisticalEntityFromJson(StatisticalEntityJson jsonObj) {
        StatisticalEntity statEntity = new StatisticalEntity();

        statEntity.setCaller(jsonObj.getCaller());
        statEntity.setEntitytype(jsonObj.getEntityType());
        statEntity.setOccurances(jsonObj.getOccurances());
        statEntity.setTimestamp(jsonObj.getTimeStamp());

        return statEntity;
    }
    public StatisticalEntityJson getStatisticalEntityJsonFromDbObj(StatisticalEntity dbEntity) {
        StatisticalEntityJson jsonObj = new StatisticalEntityJson();

        jsonObj.setCaller(dbEntity.getCaller());
        jsonObj.setEntityType(dbEntity.getEntitytype());
        jsonObj.setTimeStamp(dbEntity.getTimestamp());
        jsonObj.setOccurances(dbEntity.getOccurances());

        return jsonObj;
    }
}
