package edu.stevens.friccobo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class XmlSerialization {
    public static void main(String[] args) {
        Superhero superhero = new Superhero(
                "The Flash",
                List.of("Super Speed","Time Travel")
        );

        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(superhero);
            System.out.println(xml);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        String testXml = "<Superhero><heroName>The Flash</heroName><powers><powers>Super Speed</powers><powers>Time Travel</powers></powers><secretIdentity>shh...it's a secret</secretIdentity></Superhero>\n";
        try {
            Superhero superhero1 = xmlMapper.readValue(testXml, Superhero.class);
            System.out.println(superhero1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
