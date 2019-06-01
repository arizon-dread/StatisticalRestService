package com.arizon.StatisticalRestService.controller;

import com.arizon.StatisticalRestService.DTO.StatisticalEntityTranslator;
import com.arizon.StatisticalRestService.Repository.StatisticalEntityRepository;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import io.swagger.annotations.Api;
import model.StatisticalEntityJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arizon on 12/7/17.
 */
@Api(tags = "GetData")
@RestController
public class GetData {

    @Autowired
    EntityManager entityManager;

    @Autowired
    StatisticalEntityRepository entityRepo;

    @Autowired
    StatisticalEntityTranslator translator;

    //TODO: create crudmethods in the StatisticalEntityRepository matching methods.
    @RequestMapping(value = "/getAllEntities", method = RequestMethod.GET)
    public List<StatisticalEntityJson> getAllEntities(@RequestParam(value = "caller") long callerId) {

        List<StatisticalEntityJson> entities = new ArrayList<>();

        for (StatisticalEntity entity : entityRepo.findAllByCaller(callerId)) {
            entities.add(translator.getStatisticalEntityJsonFromDbObj(entity));
        }

        return entities;
    }

    @RequestMapping(value = "/getEntitiesBetween", method = RequestMethod.GET)
    public List<StatisticalEntityJson> getEntitiesBetween(@RequestParam(value="caller") long callerId, @RequestParam(value = "from") Date from, @RequestParam(value = "to") Date to) {

        List<StatisticalEntityJson> entities = new ArrayList<>();

        for (StatisticalEntity entity : entityRepo.findByTimestampBetween(callerId, from, to)) {
            entities.add(translator.getStatisticalEntityJsonFromDbObj(entity));
        }

        return entities;
    }


}
