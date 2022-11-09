/*
 *  Copyright 2021 The original authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.stevens.friccobo;

import java.io.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        SuperheroV1 superheroV1 = new SuperheroV1("Superman", List.of("flight", "strength", "x-ray vision"));
        System.out.println(
                superheroV1
        );

        try (
                FileOutputStream fos = new FileOutputStream("some-hero2.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){
            oos.writeObject(superheroV1);
        } catch (IOException e){
            e.printStackTrace();
        }

        try (
                FileInputStream fis  = new FileInputStream("some-hero1.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            Object o = ois.readObject();
            if(o instanceof SuperheroV1 hero) {
                System.out.println(hero);
            } else if (o instanceof Superhero hero){
                System.out.println(hero);
            } else {
                System.err.println("Objet is of unknown class");
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
