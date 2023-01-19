package feijiDemo.ui;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.util.Random;


public class Fire extends FlyObj {
  //子弹的方向
    int dir ;//0 左上角 1 垂直上飞 2 右上角

    //x y 为英雄机的xy坐标
    public Fire(int x, int y , int dir) {
        img = App.getImg("imgs/fire.png");
        assert img != null;
        //子弹缩小
        w = img.getWidth()/4;
        h = img.getHeight()/4;
        //todo 子弹的初始位置在英雄机的坐标  考虑调整
        this.x = x;
        this.y = y;
        this.dir = dir;

    }

    public void move() {
        if (dir == 0) {
            x -= 2;
            y -= 10;
        } else if (dir == 1) {
            y -= 10;
        } else if (dir == 2) {
            x += 2;
            y -= 10;
        }
    }

}
