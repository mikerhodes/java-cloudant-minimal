package searchindex;

import java.util.*;

import com.cloudant.client.api.*;

// Upload a search index:
//
// {
//   "_id": "_design/views101",
//   "_rev": "12-649b0e71ca89cdad5d66a4e07316726f",
//   "indexes": {
//     "animals": {
//       "index": "function(doc){ index(\"default\", doc._id); }"
//     }
//   }
// }

class Main {

    public static void main(String[] args) {
        CloudantClient client = ClientBuilder.account("example")
                                             .username("exampleUser")
                                             .password("examplePassword")
                                             .build();

        Database db = client.database("java-searchindex", false);

        Map<String, Object> animals = new HashMap<>();
        animals.put("index", "function(doc){ index(\"default\", doc._id); }");

        Map<String, Object> indexes = new HashMap<>();
        indexes.put("animals", animals);

        Map<String, Object> ddoc = new HashMap<>();
        ddoc.put("_id", "_design/searchindex");
        ddoc.put("indexes", indexes);

        db.save(ddoc);

    }
}
