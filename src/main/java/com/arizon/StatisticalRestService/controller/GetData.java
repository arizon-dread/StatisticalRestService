package com.arizon.StatisticalRestService.controller;

import com.arizon.StatisticalRestService.DTO.StatisticalEntityJsonToStatisticalEntity;
import com.arizon.StatisticalRestService.Repository.StatisticalEntityRepository;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arizon on 12/7/17.
 */

@RestController
public class GetData {

    @Autowired
    EntityManager entityManager;

    @Autowired
    StatisticalEntityRepository entityRepo;

    @Autowired
    StatisticalEntityJsonToStatisticalEntity translator;

    //TODO: create crudmethods in the StatisticalEntityRepository matching methods.
    @RequestMapping(value = "/getAllEntities", method = RequestMethod.GET)
    public List<StatisticalEntityJson> getAllEntities(@RequestParam(value="caller")long callerId) {

        List<StatisticalEntityJson> entities = new ArrayList<>();

        for (StatisticalEntity entity : entityRepo.findAllByCaller(callerId)) {
            entities.add(translator.getStatisticalEntityJsonFromDbObj(entity));
        }

        return entities;
    }


}
