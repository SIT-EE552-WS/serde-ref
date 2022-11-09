package edu.stevens.friccobo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class JsonSerialization {
    public static void main(String[] args) {
        Superhero superhero = new Superhero(
                "Spider-man",
                List.of("Spider Sense","Super Strength","Swinging from Webs")
        );


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(superhero);
            System.out.println(json);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        String testJson = "{\"powers\":[\"Spider Sense\",\"Super Strength\",\"Swinging from Webs\"],\"secretIdentity\":\"shh...it's a secret\"}";
        try {
            Superhero superhero1 = objectMapper.readValue(testJson, Superhero.class);
            System.out.println(superhero1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
