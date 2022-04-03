package com.apress.isf.java.test;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.java.service.SearchEngine;
import com.apress.isf.spring.annotated.service.AnnotatedSearchEngine;
import com.apress.isf.spring.service.SearchEngineService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class MyDocumentsAnnotatedTest {

    private ClassPathXmlApplicationContext context;
    private SearchEngine engine;
    private Type webtype;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-annotation-context.xml");
        engine = context.getBean(AnnotatedSearchEngine.class);
        webtype = context.getBean("webType", Type.class);
    }

    @Test
    public void testFindByType() {
        List<Document> result = engine.findByType(webtype);
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertEquals(webtype.getName(), result.get(0).getType().getName());
        assertEquals(webtype.getDesc(), result.get(0).getType().getDesc());
        assertEquals(webtype.getExtension(), result.get(0).getType().getExtension());
    }

    @Test
    public void testListAll() {
        List<Document> result = engine.listAll();
        assertNotNull(result);
        assertTrue(result.size() == 4);
    }
}
