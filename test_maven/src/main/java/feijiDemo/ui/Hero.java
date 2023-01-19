package feijiDemo.ui;


import java.util.ArrayList;
import java.util.List;

public class Hero extends FlyObj{

    List<Integer> hps = new ArrayList<>();

    int hp ;

    public Hero() {

        img = App.getImg("imgs/hero.png");
        x = 200;
        y = 500;
        w = img.getWidth();
        h = img.getHeight();
         hp =3;
    }
}
