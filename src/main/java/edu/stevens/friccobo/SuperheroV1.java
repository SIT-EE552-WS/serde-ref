package edu.stevens.friccobo;

import java.io.Serializable;
import java.util.List;

public class SuperheroV1 implements Serializable {
    public final String name;
    public final List<String> powers;

    public SuperheroV1(String name, List<String> powers){
        this.name = name;
        this.powers = powers;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "name='" + name + '\'' +
                ", powers=" + powers +
                '}';
    }
}
