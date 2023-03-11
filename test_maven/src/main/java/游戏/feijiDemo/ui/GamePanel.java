package 游戏.feijiDemo.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {
    int score = 0;
    BufferedImage bg = App.getImg("imgs/bg1.jpg");//背景图

    Hero hero = new Hero();

    List<Ep> eps = new ArrayList<>();

    List<Fire> fires = new ArrayList<>();

    //英雄鼠标位置 即为鼠标位置减主体长宽的一半
    int heroW = hero.w / 2;//57
    int heroH = hero.h / 2;//46

    public GamePanel(GameFrame gameFrame) {

        //因为 在构造方法里添加了listener 所以每次移动鼠标都会刷新
        MouseAdapter adapter = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println("点击了鼠标"+e.getButton());
                if (gameover) {
                    hero = new Hero();
                    gameover = false;
                    score = 0;
                    Random random = new Random();
                    int i = random.nextInt(5) + 1;
                    System.out.println(i);
                    bg = App.getImg("imgs/bg" + i+".jpg");

                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //
//                System.out.println("鼠标位置" + e.getX());
                //这里的hero.x  hero.y 为鼠标位置减一半的英雄机大小
                //目的是为了让飞机图片处于鼠标中心 可以理解为 hero.xy 即为飞机(图片)的位置
                //即xy在鼠标左上角(图片的一半)
                if (!gameover) {
                    hero.x = e.getX() - heroW;
                    hero.y = e.getY() - heroH;
                }
                repaint();
            }
        };
        //用于在组件上的鼠标事件***（按，释放，单击，输入和退出）***的监听器界面。 **注意：**不包含鼠标的拖动与移动
        addMouseListener(adapter);
        //用于在组件上接收鼠标运动的事件监听界面（区别于MouseListener）
        addMouseMotionListener(adapter);

        //这个玩意需要放到frame下面才能监听
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }
        };
        gameFrame.addKeyListener(keyAdapter);

    }

    @Override
    public void paint(Graphics g) {
        //画图是有顺序的  先画的会被后画的覆盖
        //画背景图
        g.drawImage(bg, 0, 0, null);
//        g.drawString("血量", 0, 0);
//        g.drawString("fenshu", 0, 0);
        //敌机
        for (int i = 0; i < eps.size(); i++) {
            g.drawImage(eps.get(i).img, eps.get(i).x, eps.get(i).y, eps.get(i).w, eps.get(i).h, null);
        }
//        for (Ep ep : eps) {
//            g.drawImage(ep.img, ep.x, ep.y, ep.w, ep.h, null);
//
//        }

//        for (Fire fire : fires) {
//            g.drawImage(fire.img, fire.x, fire.y, fire.w, fire.h, null);
//        }
        //英雄机
        g.drawImage(hero.img, hero.x, hero.y, null);
        //子弹
        for (int i = 0; i < fires.size(); i++) {
            g.drawImage(fires.get(i).img, fires.get(i).x, fires.get(i).y, fires.get(i).w, fires.get(i).h, null);
        }

        //分数
        g.setColor(Color.white);
        g.setFont(new Font("楷体", Font.BOLD, 20));

        g.drawString("分数" + score, 10, 30);

        //英雄机的生命
        for (int i = 0; i < hero.hp; i++) {
            g.drawImage(hero.img, 350 + i * 40, 5, 30, 30, null);
        }

        //当游戏结束时
        if (gameover) {
            g.setColor(Color.red);
            g.drawString("sss",20,300);

        }

    }

    public void action() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (!gameover) {

                        if (eps.size() < 10) {
                            epEnter();
                        }
                                    epMove();
                    shoot();
                    shootMove();
                    //判断是否击中敌机
                    shootEP();

                    shootHero();
                    }

                    try {
                        //即主体游戏的刷新间隔
                        //每次刷新频率 0.015s 左右
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    repaint();
                }
            }


        }.start();
    }

    boolean gameover;


    private void shootHero() {
        for (int i = 0; i < eps.size(); i++) {
            Ep ep = eps.get(i);
            if (ep.hitBy(hero)) {
                eps.remove(ep);
                hero.hp--;

                score += 10;
                if (hero.hp <= 0) {
                    gameover = true;
                    eps.clear();
                    fires.clear();
                }
            }
        }

    }

    //判断是否击中敌机
    private void shootEP() {
        for (int i = 0; i < fires.size(); i++) {
            Fire fire = fires.get(i);
            //判断每个子弹是否击中
            bang(fire);
        }
    }

    private void bang(Fire fire) {
        for (int i = 0; i < eps.size(); i++) {
            Ep ep = eps.get(i);
            if (ep.shootBy(fire)) {
                //如果被击中
                //1 敌机死亡
                ep.hp--;
                if (ep.hp == 0) {
                    eps.remove(i);
                    score += 10;

                }
                fires.remove(fire);

            }
        }
    }

    //子弹发射频率
    int index_shoot = 0;

    private void shoot() {
        index_shoot++;
        if (index_shoot > 10) {
//            System.out.println("hero.x"+hero.x);
//            System.out.println("hero.y"+hero.y);
            //飞机的大小114 93 子弹的大小 100 103
            //想让子弹在图片居中射出来 即为hero.x + hero.w/2 - fire.w/2   即为fire.x
            //如不好理解 则可以画图理解
            //子弹的大小w 为25  因为缩小了4倍
            //这里((hero.w - 25) / 2) =44.5
            Fire fire = new Fire(hero.x + ((hero.w - 25) / 2) - 30, hero.y, 0);
            fires.add(fire);
            Fire fire1 = new Fire(hero.x + ((hero.w - 25) / 2), hero.y, 1);
            fires.add(fire1);
            Fire fire2 = new Fire(hero.x + ((hero.w - 25) / 2) + 30, hero.y, 2);
            fires.add(fire2);
            index_shoot = 0;
        }
    }

    private void shootMove() {
//        System.out.println("size " + fires.size());
//        System.out.println(eps.size());
        for (int i = 0; i < fires.size(); i++) {
            //子弹往上移动
            fires.get(i).move();
            //注意这里remove需要放在下面
            if (fires.get(i).y < -1000) {
                fires.remove(fires.get(i));
            }
        }

    }


    int index_epMove = 0;

    private void epMove() {
        index_epMove++;
        if (index_epMove > 3) {
            for (int i = 0; i < eps.size(); i++) {

                eps.get(i).move();

                if (eps.get(i).y > 768) {
                    eps.remove(eps.get(i));
                }
            }
            index_epMove = 0;
        }
    }

    int index_epEnter = 0;

    private void epEnter() {
        index_epEnter++;
        //画面每刷新20次 才会加一个飞机  因为画面刷新频率太快了
        if (index_epEnter >= 10) {
            Ep ep = new Ep();
            eps.add(ep);
            index_epEnter = 0;
        }

    }


}
