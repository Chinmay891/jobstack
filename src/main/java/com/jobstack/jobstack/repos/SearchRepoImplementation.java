package com.jobstack.jobstack.repos;

import com.jobstack.jobstack.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImplementation implements SearchRepository{

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Post> findByText(String txt) {
        final List<Post> posts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("JobDB");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                new Document("text",
                new Document("query", txt).append("path", Arrays.asList("techs", "desc")))),
                new Document("$sort",
                new Document("exp", -1L)),
                new Document("$limit", 2L)));
        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));
        return posts;
    }
}
