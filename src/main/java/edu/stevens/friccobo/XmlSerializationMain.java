package edu.stevens.friccobo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class XmlSerializationMain {
    public static void main(String[] args) {
        SuperHeroV2 hero = new SuperHeroV2(
                "Superman",
                List.of(
                        "flight",
                        "super strength",
                        "laser vision",
                        "speed"
                )
        );

        XmlMapper mapper = new XmlMapper();
        String xml = "";
        try {
            xml = mapper.writeValueAsString(hero);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            SuperHeroV2 hero2 = mapper.readValue(xml, SuperHeroV2.class);
            System.out.println(hero2);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
