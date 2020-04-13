package com.practice.java.core.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Lambda {

    public static void main(String[] args) {
        Game football = new Game() {
            public void play() {
                System.out.println("I am playing football");

            }
        };

        Game cricket = new Game() {
            public void play() {
                System.out.println("I am playing cricket");

            }
        };

        Game footballLambda = () ->  System.out.println("I am playing football");
        Game cricketLambda =() -> System.out.println("I am playing cricket");

        Series cricketSeries = type -> System.out.println("I'm watching "+type+" Series" );
        cricketSeries.play("ODI");


        List<String> players = Arrays.asList("Virat", "Rohit", "Rahul", "Jhadhav");

        for(String player: players) {
            if(player.equals("Virat")) {
                System.out.println("Virat is in the squad");
            }
        }

        players
                .stream()
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return player.equals("Virat");
                    }
                })
                .filter(player -> player.equals("Virat"))
                .forEach(player -> System.out.println("Yes. Virat is in the squad"));

        Optional<String> optional = players
                .stream()
                .filter(player -> player.equals("Virat"))
                .findFirst();

        if(optional.isPresent()){
            System.out.println("Yes. Virat is in the squad");
        }

    }


}

interface Game{
    void play();
}

interface Series{
    void play(String type);
}