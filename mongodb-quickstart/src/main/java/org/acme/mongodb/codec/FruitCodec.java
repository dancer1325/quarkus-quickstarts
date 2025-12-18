package org.acme.mongodb.codec;

import java.util.UUID;

import org.acme.mongodb.Fruit;
import org.bson.BsonReader;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.CollectibleCodec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

import com.mongodb.MongoClientSettings;

public class FruitCodec implements CollectibleCodec<Fruit> {

    private final Codec<Document> documentCodec;

    public FruitCodec() {
        this.documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public void encode(BsonWriter writer, Fruit fruit, EncoderContext encoderContext) {
        Document doc = new Document();
        doc.put("name", fruit.getName());
        doc.put("description", fruit.getDescription());
        documentCodec.encode(writer, doc, encoderContext);
    }

    @Override
    public Class<Fruit> getEncoderClass() {
        return Fruit.class;
    }

    @Override
    public Fruit generateIdIfAbsentFromDocument(Fruit document) {
        if (!documentHasId(document)) {
            document.setId(UUID.randomUUID().toString());
        }
        return document;
    }

    @Override
    public boolean documentHasId(Fruit document) {
        return document.getId() != null;
    }

    @Override
    public BsonValue getDocumentId(Fruit document) {
        return new BsonString(document.getId());
    }

    @Override
    public Fruit decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);

        var name = document.getString("name");
        var description = document.getString("description");

        // 1. -- via -- empty constructor
/*        Fruit fruit = new Fruit();
        fruit.setName(name);
        fruit.setDescription(description);*/

        // 2. -- via -- nonEmpty constructor
        Fruit fruit = new Fruit(name, description);
        if (document.getString("id") != null) {
            fruit.setId(document.getString("id"));
        }

        return fruit;
    }
}
