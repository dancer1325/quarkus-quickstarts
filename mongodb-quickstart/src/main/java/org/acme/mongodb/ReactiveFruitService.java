package org.acme.mongodb;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.bson.Document;

import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class ReactiveFruitService {

    @Inject
    ReactiveMongoClient mongoClient;

    public Uni<List<Fruit>> list() {
        return getCollection().find()
                .map(doc -> {
                    var name = doc.getString("name");
                    var description = doc.getString("description");
                    // 1. -- via -- empty constructor
                    Fruit fruit = new Fruit();
                    fruit.setName(name);
                    fruit.setDescription(description);

                    // 2. -- via -- nonEmpty constructor
                    /*Fruit fruit = new Fruit(name, description);*/
                    return fruit;
                }).collect().asList();
    }

    public Uni<Void> add(Fruit fruit) {
        Document document = new Document()
                .append("name", fruit.getName())
                .append("description", fruit.getDescription());
        return getCollection().insertOne(document)
                .onItem().ignore().andContinueWithNull();
    }

    private ReactiveMongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("fruit").getCollection("reactive_fruit");
    }
}
