package com.swim;

import java.util.List;
import java.util.Map;

/**
 * Created by xugenli on 2016/12/27.
 */
public class RickHi implements Hi {

    public void setTel(Map<String, Integer> tel) {
        this.tel = tel;
    }

    private Map<String,Integer> tel;

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    private List<String> songs;

    private Morty morty;

    private int age;

    public void setMorty(Morty morty) {
        this.morty = morty;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public RickHi() {
    }

    public RickHi(int age) {
        this.age = age;
    }

    public RickHi(Morty morty, int age) {
        this.morty = morty;
        this.age = age;
    }

    public void say() {
        System.out.println("This is Rick, Bitch!");
        System.out.println("I'm " + age);
        System.out.println("Let's see what's Morty say:"+morty.girlName());
        System.out.println("My favourite song is "+songs.get(2));
        System.out.println("Jason....hmmm "+ tel.get("jason"));
    }
}
