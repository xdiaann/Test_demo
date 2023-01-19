package feijiDemo.ui;

import java.awt.image.BufferedImage;
import java.sql.SQLOutput;
import java.util.Random;

public class Ep extends FlyObj{
//飞机的速度
    int sp;
    int hp;

    public Ep() {
        Random random = new Random();
        int i = random.nextInt(15) + 1;
        String path = "imgs/ep" + (i<10?"0":"")+i + ".png";
        img = App.getImg(path);
        w = img.getWidth();
        h = img.getHeight();
        //随机位置生成  框架宽度512
        x =  random.nextInt(512-w);
        y = -h/2;
        int i1 = random.nextInt(9) + 1;

        hp = i1;
    }


    void  move() {
        y += 10;
    }


    public boolean shootBy(Fire fire) {
        //子弹的xy轴 需同时满足
        boolean hit = x <= fire.x + fire.w && x >= fire.x - w && y<=fire.y+fire.h&& y>= fire.y-h;
        return hit;
    }

    public boolean hitBy(Hero hero) {
        boolean hit = x <= hero.x + hero.w && x >= hero.x - w && y<=hero.y+hero.h&& y>= hero.y-h;
        return hit;
    }
}
