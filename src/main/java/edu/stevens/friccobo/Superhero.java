package edu.stevens.friccobo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Superhero implements Serializable {
    final static long serialVersionUID = -1031933254174646972L;

    @JsonProperty(
            value = "heroName",
            defaultValue = "Some name",
            required = true
    )
    private final String name;
    public final List<String> powers;

    public final String secretIdentity;

    @JsonCreator
    public Superhero(
            @JsonProperty(value = "heroName",
                    defaultValue = "Some name",
                    required = true) String name,
            @JsonProperty("powers") List<String> powers
    ){
        this.name = name;
        this.powers = powers;
        this.secretIdentity = "shh...it's a secret";
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "name='" + name + '\'' +
                ", powers=" + powers +
                ", identity=" + secretIdentity +
                '}';
    }
}
