package com.arizon.StatisticalRestService.test;

import com.arizon.StatisticalRestService.Repository.StatisticalEntityRepository;
import com.arizon.StatisticalRestService.StatisticalRestServiceApplication;
import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import com.arizon.StatisticalRestService.service.PersistenceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StatisticalRestServiceApplication.class)
public class SaveDataTest {
    //process-resources spring-boot:run

    @Autowired
    PersistenceService ps;

    @Autowired
    StatisticalEntityRepository repo;

    @Before
    public void setUp() throws Exception {

        EntityType grams = new EntityType("g");
        EntityType degrees = new EntityType("C");

        ps.persist(grams);
        ps.persist(degrees);

        Caller caller = new Caller();
        caller.setCallerName("localhost");
        caller.setCallerAddress("127.0.0.1");
        Set<EntityType> entityTypes = new HashSet<>();
        entityTypes.add(grams);
        entityTypes.add(degrees);
        caller.setEntityTypes(entityTypes);


        ps.persist(caller);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveStatisticalEntities() {

        try {


            StatisticalEntityJson entity = new StatisticalEntityJson();

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = df.format(new Date());
            Date date = df.parse(strDate);

            entity.setEntityType("g");
            entity.setOccurances(1);
            entity.setTimeStamp(date);
            entity.setValue(10000);

            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(entity);

            URL url = new URL("http://localhost:8080/saveData?caller=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.flush();

            assert conn.getResponseCode() == HttpURLConnection.HTTP_CREATED;
            long l = 1;
            Optional<StatisticalEntity> persistedEntity = repo.findById(l);

            StatisticalEntity retrievedEntity = persistedEntity.get();
            assert retrievedEntity.getEntitytype().getUnit() == entity.getEntityType();
            assert retrievedEntity.getTimeStamp() == entity.getTimeStamp();
            assert retrievedEntity.getValue() == entity.getValue();
        } catch (java.io.IOException ioe) {

        } catch (java.text.ParseException parseExc) {

        }


    }
}