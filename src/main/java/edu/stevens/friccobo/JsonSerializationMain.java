package edu.stevens.friccobo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonSerializationMain {
    public static void main(String[] args) {
        SuperHeroV2 heroV2 = new SuperHeroV2(
                "Batman",
                List.of(
                        "lots of money",
                        "martial arts"
                )
        );

        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(heroV2);
            System.out.println(json);
            SuperHeroV2 heroDeserialized = mapper.readValue(json, SuperHeroV2.class);
            System.out.println(heroDeserialized);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
