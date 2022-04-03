package com.apress.isf.spring.annotated.data;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;
import com.apress.isf.spring.data.DocumentDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("documentDAO")
public class AnnotatedDocumentRepository implements DocumentDAO {

    public Document[] getAll() {
        return storage();
    }

    private Document[] storage() {
        List<Document> result = new ArrayList<>();

        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Szablon książki");
        document.setType(type);
        document.setLocation("/Users/maciek/Documents/Random/Book Template.pdf");

        result.add(document);

        document = new Document();
        document.setName("Przykładowa umowa");
        document.setType(type);
        document.setLocation("/Users/maciek/Documents/Contracts/Sample Contract.pdf");

        result.add(document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Notatki tekstowe");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/maciek/Documents/Random/Clustering with RabbitMQ.txt");

        result.add(document);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Łącze sieciowe");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        result.add(document);

        return result.toArray(new Document[result.size()]);
    }
}
