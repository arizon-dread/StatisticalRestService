package com.arizon.StatisticalRestService.controller;

import com.arizon.StatisticalRestService.DTO.StatisticalEntityTranslator;
import com.arizon.StatisticalRestService.Repository.StatisticalEntityRepository;
import com.arizon.StatisticalRestService.exception.BadRequestException;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import io.swagger.annotations.Api;
import model.StatisticalEntityJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arizon on 12/7/17.
 **/
@Api(tags = "GetData")
@RestController
@RequestMapping("/")
public class GetData {

    @Autowired
    EntityManager entityManager;

    @Autowired
    StatisticalEntityRepository entityRepo;

    @Autowired
    StatisticalEntityTranslator translator;

    //TODO: create crudmethods in the StatisticalEntityRepository matching methods.
    @RequestMapping(value = "/getAllEntities", method = RequestMethod.GET)
    public @ResponseBody List<StatisticalEntityJson> getAllEntities(@RequestParam(value = "caller") long callerId) {

        List<StatisticalEntityJson> entities = new ArrayList<>();

        for (StatisticalEntity entity : entityRepo.findAllByCaller(callerId)) {
            entities.add(translator.getStatisticalEntityJsonFromDbObj(entity));
        }

        return entities;
        }

    @RequestMapping(value = "/getEntitiesBetween", method = RequestMethod.GET)
    public @ResponseBody List<StatisticalEntityJson> getEntitiesBetween(@RequestParam(value="caller") long callerId,
                                                                        @RequestParam(value = "from") String from,
                                                                        @RequestParam(value = "to") String to)
            throws BadRequestException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        List<StatisticalEntityJson> entities = new ArrayList<>();
        try {
            Date dateFrom = sdf.parse(from);
            Date dateTo = sdf.parse(to);

            for (StatisticalEntity entity : entityRepo.findByTimestampBetween(callerId, dateFrom, dateTo)) {
                entities.add(translator.getStatisticalEntityJsonFromDbObj(entity));
            }
        } catch (ParseException pe) {

            throw new BadRequestException("Invalid Date format");
        }


        return entities;
    }


}
