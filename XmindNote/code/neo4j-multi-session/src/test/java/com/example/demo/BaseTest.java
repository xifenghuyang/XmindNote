package com.example.demo;

import com.example.driver1.*;
import com.example.driver2.BarEntity;
import com.example.driver2.BarRepository;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.response.model.NodeModel;
import org.neo4j.ogm.response.model.QueryResultModel;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.Name;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Map;

/**
 * @author admin
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Autowired
    FooRepository fooRepository;
    @Autowired
    BarRepository barRepository;

    @Autowired
    SessionUse sessionUse;
    @Autowired
    TemplateUse templateUse;

    @Test
    public void testDriver1() {
        log.info("sfsdf");
        FooEntity fooEntity = new FooEntity("this is foo");
        BarEntity barEntity = new BarEntity("this is bar");
        fooRepository.save(fooEntity);
        barRepository.save(barEntity);
//        fooRepository.deleteAll();
    }


    @Test
    public void testSession1() {
//        sessionUse.session1.query(String.class, "Match (n) return n", new JSONObject());
        
        sessionUse.session1.query(String.class, "Match (n.name) return n.name", Collections.emptyMap());

        QueryResultModel mmm = (QueryResultModel)sessionUse.session1.query( "Match (n) return n", new JSONObject());
//        mmm.forEach(x->{(NodeModel)x.ge});

//        templateUse.template.execute("Match (n) return n");
        StringBuffer cql = new StringBuffer();

//        session1.
    }

}
