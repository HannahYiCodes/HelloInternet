package com.careerdevs.hellointernet.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class RootController {

    @GetMapping("/")
    public String mainPage() {
        return "The Main Page";
    }

    @GetMapping("/hello")
    public String helloCareerDevs() {
        return "You requested the root route";
    }

    @GetMapping("/random")
    public Integer randomInt() {
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        return n;
    }

    @GetMapping("/joke")
    public String randomJoke() {
        String[] jokes = {
                "Why do we tell actors to break a leg?\n\nBecause every play has a cast.",
                "What do you call a magic dog?\n\nA Labracadabrador.",
                "Why couldn't the pony sing a lullaby?\n\nShe was a little horse.",
                "An apple a day really can keep the doctor away.\n\n...but only if you aim well.",
                "What did one plate say to the other?\n\nTonight, dinner's on me!"
        };

        String jokeSelect = (jokes[new Random().nextInt(jokes.length)]);
        return jokeSelect;
    }

    @GetMapping("/requestParam")
    public String getParamRequest(@RequestParam(value = "FirstInt", defaultValue = "1") int first,
                           @RequestParam(value = "SecondInt", defaultValue = "30") int second) {
        return "Here are my parameters: " + first + ", " + second;
    }

    @GetMapping("/home/{id}")
    @ResponseBody
    public String getHomeOne(@PathVariable String id) {
        return "ID: " + id;
    }
}
