package com.iridiumhawk.dao;

import com.iridiumhawk.config.AppInit;
import com.iridiumhawk.config.Config;
import com.iridiumhawk.config.HibernateConfig;
import com.iridiumhawk.config.WebConfig;
import com.iridiumhawk.service.ToDoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * Created by hawk on 07.05.2017.
 */
@ContextConfiguration(classes = {Config.class, HibernateConfig.class})
//@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SqlGroup({
//        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:populateMysql.sql")
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:populateHsql.sql")
//        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:populateHsql.sql")
})
@ActiveProfiles("dev")
public class ToDoDaoImplTest {

//    AnnotationConfigApplicationContext ctx;

    @Autowired
    private ToDoService service;

    @Before
    public void setUp() throws Exception {

   /*     ctx = new AnnotationConfigApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("dev");
        Environment env = ctx.getEnvironment();
        ctx.register(WebConfig.class, HibernateConfig.class);

        ctx.refresh();
        service = ctx.getBean(ToDoService.class);
        System.out.println(ctx.getMessage("message", null, Locale.getDefault()));*/

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findById() throws Exception {
        service.findById(5);
    }

    @Test
    public void saveNote() throws Exception {

    }

    @Test
    public void deleteNote() throws Exception {

    }

    @Test
    public void findAllNotes() throws Exception {

    }

    @Test
    public void findByNote() throws Exception {

    }

    @Test
    public void findByDate() throws Exception {

    }

}