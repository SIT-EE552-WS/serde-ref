package edu.stevens.friccobo;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionMain {
    public static void main(String[] args) {
        Class<SuperHeroV2> clazz = SuperHeroV2.class;
        SuperHeroV2 thor = new SuperHeroV2("Thor", List.of("thunder", "lightning"));


        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        try {
            Field name = clazz.getField("name");

            name.setAccessible(true);
            name.set(thor, "Someone else");

            System.out.println(thor);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
