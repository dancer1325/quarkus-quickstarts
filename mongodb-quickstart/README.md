Quarkus guide: https://quarkus.io/guides/mongodb

* goal
  * application / manage a list of fruits

# Creating your first JSON REST service
## JSON serialization layer
### ️requirements: have a default constructor
* | [Fruit.java](src/main/java/org/acme/mongodb/Fruit.java)
  * comment `public Fruit() {}`
  * `mvn verify`
  * check how you get errors " com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `org.acme.mongodb.Fruit` (no Creators, like default constructor, exist)"

# TODO: 

# Notes
* [FruitService](src/main/java/org/acme/mongodb/FruitService.java)
  * == our application's business layer /
    * store/load the fruits -- from the -- mongoDB database
