package edu.stevens.friccobo;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionMain {
    public static void main(String[] args) {
        Superhero superhero = new Superhero("Batman", List.of("lots of money", "martial arts"));

        Class<Superhero> superheroClass = Superhero.class;
        System.out.println("{");
        for (Field declaredField : superheroClass.getDeclaredFields()) {
            try {
                declaredField.setAccessible(true);
                if(declaredField.getType().isAssignableFrom(String.class)){
                    System.out.println("\"" + declaredField.getName() + "\": \""+declaredField.get(superhero)+"\"");
                } else if(declaredField.getType().isAssignableFrom(List.class)) {
                    System.out.println("\"" + declaredField.getName() + "\": [");
                    Object o = declaredField.get(superhero);
                    boolean first = true;
                    if(o instanceof List list){
                        for (Object o1 : list) {
                            if(!first){
                                System.out.print(",");
                            }
                            first = false;
                            System.out.println("\"" + o1 + "\"");
                        }
                    }
                    System.out.println("]");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("}");
    }
}
