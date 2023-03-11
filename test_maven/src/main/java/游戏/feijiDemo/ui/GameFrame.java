package 游戏.feijiDemo.ui;


import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    static int state = 0;

    public GameFrame()   {
        //因为窗体本身需要一定的像素  所以xy各加了一点
        setSize(512 + 16, 768 + 39);
        setPreferredSize(new Dimension(512 , 768));
        //weizhi
        setLocationRelativeTo(null);

        setTitle("飞机大战");
        //是否可以移动
        setResizable(false);
        //默认关闭选项   关闭窗口退出程序
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) throws InterruptedException {

        GameFrame gameFrame = new GameFrame();
        //GamePanel 里面的 KeyAdapter 这个玩意需要放到frame下面才能监听
//        GamePanel gamePanel = new GamePanel(gameFrame);
        GamePanel gamePanel = new GamePanel(gameFrame);

        //画板
        //窗体
        gamePanel.action();
        gameFrame.add(gamePanel);
        //是否显示窗体
        gameFrame.setVisible(true);
    }
}
