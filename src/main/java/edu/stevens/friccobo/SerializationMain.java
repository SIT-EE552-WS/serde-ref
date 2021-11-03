package edu.stevens.friccobo;

import java.io.*;
import java.util.Collections;

public class SerializationMain {
    public static void main(String[] args) {
//        SuperHero hero = new SuperHero("Spider-Man", "Does whatever a spider can");
//        System.out.println(hero);
//
//        try(
//                FileOutputStream fos = new FileOutputStream("some-hero.ser");
//                ObjectOutputStream oos = new ObjectOutputStream(fos);
//                ){
//            oos.writeObject(hero);
//        } catch (IOException e){
//            e.printStackTrace();
//        }


        try (
                FileInputStream fis = new FileInputStream("some-hero.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            Object o = ois.readObject();
            if( o  instanceof SuperHero ) {
                SuperHero hero = (SuperHero) o;
                System.out.println(hero);
                System.out.println(hero.name);
                System.out.println(hero.toV2());
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static class SuperHero implements Serializable {
        public final String name;
        public final String powers;
        final static long serialVersionUID = 1880808863449862067L;

        public SuperHero(String name, String powers) {
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

        public SuperHeroV2 toV2(){
            return new SuperHeroV2(
                    this.name,
                    Collections.singletonList(powers)
            );
        }
    }

}
