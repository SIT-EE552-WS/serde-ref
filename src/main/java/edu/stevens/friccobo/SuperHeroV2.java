package edu.stevens.friccobo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class SuperHeroV2 implements Serializable {
    @JsonProperty("heroName")
    public final String name;

    @JsonIgnore
    public final List<String> powers;
    final static long serialVersionUID = 2L;

    @JsonCreator
    public SuperHeroV2(
            @JsonProperty("heroName") String name,
            @JsonProperty("powers") List<String> powers
    ) {
        this.name = name;
        this.powers = powers;
    }

    @Override
    public String toString() {
        return "SuperHero{" +
                "name='" + name + '\'' +
                ", powers='" + powers + '\'' +
                '}';
    }
}
