package parsing_json;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class ElementCollectionInitializer {

    public static ElementCollection generate() throws FileNotFoundException {

        ElementCollection elementsCollection = new ElementCollection();
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader("/Users/garrettarant/Dev/JavaAssessment3/src/main/resources/periodic_table.json"));
        Element[] elements = gson.fromJson(reader, Element[].class);
        Collections.addAll(elementsCollection, elements);
        return elementsCollection;
    }
}
