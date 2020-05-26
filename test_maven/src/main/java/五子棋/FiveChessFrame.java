package 五子棋;

/**
 * @author MR.Z
 * @date 2020/1/2 23:58
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiveChessFrame extends JFrame implements MouseListener, Runnable {
    private static final long serialVersionUID = 1L;
    int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    int hight = Toolkit.getDefaultToolkit().getScreenSize().height;
    // 背景图片
    BufferedImage bjImage = null;
    // 保存棋子坐标
    int x = 0;
    int y = 0;
    // 保存之前下过的棋子坐标
    // 其中数据：0:表示这个点没有棋子 1：表示黑子 2：表示白子
    int[][] allChess = new int[19][19];
    // 标识当前是黑棋还是白旗下下一步
    boolean isBlack = true;
    // 标识当前游戏是否可以继续
    boolean canPlay = true;
    // 保存显示的提示信息
    String message = "黑方先行";
    // 保存最多拥有多少时间(秒)
    int maxTime = 0;
    // 做倒计时的线程类
    Thread t = new Thread(this);
    // 保存黑方与白方的剩余时间
    int blackTime = 0;
    int whiteTime = 0;
    // 保存双方剩余时间的显示信息
    String blackMessage = "无限制";
    String whiteMessage = "无限制";

    @SuppressWarnings("deprecation")
    public FiveChessFrame() {
        this.setTitle("五子棋");
        this.setSize(500, 500);
        this.setLocation((width - 500) / 2, (hight - 500) / 2);
        this.addMouseListener(this);
        // this.setResizable(false);
        this.setVisible(true);

        t.start();
        t.suspend();// 线程挂起

        // 刚打开的时候刷新屏幕,防止开始游戏时无法显示的问题
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            bjImage = ImageIO.read(new File("src/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        // 双缓存技术 防止屏幕闪烁 但不知道为什么，使用双缓存技术以后，效果特不好，所以没用，如果使用的话，下面的 g 改为 g2 就可以了
        // BufferedImage bi=new
        // BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
        // Graphics g2=bi.createGraphics();

        g.drawImage(bjImage, 0, 20, this);
        g.setFont(new Font("黑体", Font.BOLD, 20));
        g.drawString("游戏信息：" + message, 120, 60);
        g.setFont(new Font("宋体", 0, 14));
        g.drawString("黑方时间：" + blackMessage, 30, 470);
        g.drawString("白方时间：" + whiteMessage, 260, 470);

        // 绘制棋盘
        for (int i = 0; i < 19; i++) {
            g.drawLine(10, 70 + 20 * i, 370, 70 + 20 * i);
            g.drawLine(10 + 20 * i, 70, 10 + 20 * i, 430);
        }
        // 标注小圆点位
        g.fillOval(68, 128, 4, 4);
        g.fillOval(308, 128, 4, 4);
        g.fillOval(308, 368, 4, 4);
        g.fillOval(68, 368, 4, 4);
        g.fillOval(188, 128, 4, 4);
        g.fillOval(68, 248, 4, 4);
        g.fillOval(188, 368, 4, 4);
        g.fillOval(188, 248, 4, 4);
        g.fillOval(308, 248, 4, 4);

        // //绘制棋子
        // x=(x-10)/20*20+10; //是为了取得交叉点的坐标
        // y=(y-70)/20*20+70;
        // //黑子
        // g.fillOval(x-7, y-7, 14, 14);
        // //白子
        // g.setColor(Color.BLACK);
        // g.fillOval(x-7, y-7, 14, 14);
        // g.setColor(Color.BLACK);
        // g.drawOval(x-7, y-7, 14, 14);

        // 输出数组中所有数值
        // 绘制全部棋子
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (allChess[i][j] == 1) {
                    // 黑子
                    int tempX = i * 20 + 10;
                    int tempY = j * 20 + 70;
                    g.fillOval(tempX - 7, tempY - 7, 14, 14);
                }
                if (allChess[i][j] == 2) {
                    // 白子
                    int tempX = i * 20 + 10;
                    int tempY = j * 20 + 70;
                    g.setColor(Color.WHITE);
                    g.fillOval(tempX - 7, tempY - 7, 14, 14);
                    g.setColor(Color.BLACK);
                    g.drawOval(tempX - 7, tempY - 7, 14, 14);
                }
            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    private boolean checkWin() {
        boolean flag = false;
        // 保存共有多少相同颜色棋子相连
        int count = 1;
        // 判断横向 特点：allChess[x][y]中y值相同
        int color = allChess[x][y];
        // 判断横向
        count = this.checkCount(1, 0, color);
        if (count >= 5) {
            flag = true;
        } else {
            // 判断纵向
            count = this.checkCount(0, 1, color);
            if (count >= 5) {
                flag = true;
            } else {
                // 判断右上左下
                count = this.checkCount(1, -1, color);
                if (count >= 5) {
                    flag = true;
                } else {
                    // 判断左下右上
                    count = this.checkCount(1, 1, color);
                    if (count >= 5) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    // 判断棋子连接数量
    private int checkCount(int xChange, int yChange, int color) {
        int count = 1;
        int tempX = xChange;
        int tempY = yChange;
        while (x + xChange >= 0 && x + xChange <= 18 && y + yChange >= 0
                && y + yChange <= 18
                && color == allChess[x + xChange][y + yChange]) {
            count++;
            if (xChange != 0) {
                xChange++;
            }
            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                } else {
                    yChange--;
                }
            }
        }
        xChange = tempX;
        yChange = tempY;
        while (x - xChange >= 0 && x - xChange <= 18 && y - yChange >= 0
                && y - yChange <= 18
                && color == allChess[x - xChange][y - yChange]) {
            count++;
            if (xChange != 0) {
                xChange++;
            }
            if (yChange != 0) {
                if (yChange > 0) {
                    yChange++;
                } else {
                    yChange--;
                }
            }
        }
        return count;
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @SuppressWarnings("deprecation")
    @Override
    public void mousePressed(MouseEvent e) {
        if (canPlay) {
            x = e.getX();
            y = e.getY();
            if (x >= 10 && x <= 370 && y >= 70 && y <= 430) {
                // System.out.println("在棋盘范围内："+x+"--"+y);
                x = (x - 10) / 20; // 是为了取得交叉点的坐标
                y = (y - 70) / 20;
                if (allChess[x][y] == 0) {
                    // 判断当前要下的是什么棋子
                    if (isBlack) {
                        allChess[x][y] = 1;
                        isBlack = false;
                        message = "轮到白方";
                    } else {
                        allChess[x][y] = 2;
                        isBlack = true;
                        message = "轮到黑方";
                    }
                    // 判断这个棋子是否和其他棋子连成5个
                    boolean winFlag = this.checkWin();
                    if (winFlag) {
                        JOptionPane.showMessageDialog(this, "游戏结束,"
                                + (allChess[x][y] == 1 ? "黑方" : "白方") + "获胜!");
                        canPlay = false;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "当前位子已经有棋子，请重新落子！！！");
                }

                this.repaint();
            }
        }
        // 点击 开始游戏 按钮
        if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 70
                && e.getY() <= 100) {
            int result = JOptionPane.showConfirmDialog(this, "是否重新开始游戏？");
            if (result == 0) {
                // 现在重新开始游戏
                // 重新开始所要做的操作：1)把棋盘清空,allChess数组中全部数据归0；
                // 2)游戏相关信息显示初始化
                // 3)将下一步下棋改为黑方
                for (int i = 0; i < 19; i++) {
                    for (int j = 0; j < 19; j++) {
                        allChess[i][j] = 0;
                    }
                }
                // 另一种方式 allChess=new int[19][19]
                message = "黑方先行";

                isBlack = true;
                blackTime = maxTime;
                whiteTime = maxTime;
                if (maxTime > 0) {
                    blackMessage = maxTime / 3600 + ":"
                            + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                            + (maxTime - maxTime / 60 * 60);
                    whiteMessage = maxTime / 3600 + ":"
                            + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                            + (maxTime - maxTime / 60 * 60);
                    t.resume();
                } else {
                    blackMessage = "无限制";
                    whiteMessage = "无限制";
                }
                this.repaint();// 如果不重新调用，则界面不会刷新

            }

        }// 点击 游戏设置 按钮
        if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 120
                && e.getY() <= 150) {
            String input = JOptionPane
                    .showInputDialog("请输入游戏的最多时间(单位：分钟)，如果输入0 ，表示没有时间限制");
            try {
                maxTime = Integer.parseInt(input) * 60;
                if (maxTime < 0) {
                    JOptionPane.showMessageDialog(this, "请正确提示信息，不允许输入负数");
                }
                if (maxTime == 0) {
                    int result = JOptionPane.showConfirmDialog(this, "设置完成，是否重新开始游戏？");
                    if (result == 0) {
                        // 现在重新开始游戏
                        // 重新开始所要做的操作：1)把棋盘清空,allChess数组中全部数据归0；
                        // 2)游戏相关信息显示初始化
                        // 3)将下一步下棋改为黑方
                        for (int i = 0; i < 19; i++) {
                            for (int j = 0; j < 19; j++) {
                                allChess[i][j] = 0;
                            }
                        }
                        // 另一种方式 allChess=new int[19][19]
                        message = "黑方先行";

                        isBlack = true;
                        blackTime = maxTime;
                        whiteTime = maxTime;
                        blackMessage = "无限制";
                        whiteMessage = "无限制";
                        this.repaint();// 如果不重新调用，则界面不会刷新

                    }
                }
                if (maxTime > 0) {
                    int result = JOptionPane.showConfirmDialog(this,
                            "设置完成，是否重新开始游戏？");
                    if (result == 0) {
                        // 现在重新开始游戏
                        // 重新开始所要做的操作：1)把棋盘清空,allChess数组中全部数据归0；
                        // 2)游戏相关信息显示初始化
                        // 3)将下一步下棋改为黑方
                        for (int i = 0; i < 19; i++) {
                            for (int j = 0; j < 19; j++) {
                                allChess[i][j] = 0;
                            }
                        }
                        // 另一种方式 allChess=new int[19][19]
                        message = "黑方先行";

                        isBlack = true;
                        blackTime = maxTime;
                        whiteTime = maxTime;
                        blackMessage = maxTime / 3600 + ":"
                                + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                                + (maxTime - maxTime / 60 * 60);
                        whiteMessage = maxTime / 3600 + ":"
                                + (maxTime / 60 - maxTime / 3600 * 60) + ":"
                                + (maxTime - maxTime / 60 * 60);
                        t.resume();
                        this.repaint();// 如果不重新调用，则界面不会刷新

                    }
                }
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(this, "请正确提示信息");
            }
        }// 点击 游戏说明 按钮
        if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 170
                && e.getY() <= 200) {
            JOptionPane.showMessageDialog(this,
                    "这是一个五子棋游戏程序，黑白双方轮流下棋，当某一方连到五子时，游戏结束。");
        }// 点击 认输 按钮
        if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 270
                && e.getY() <= 300) {
            int result = JOptionPane.showConfirmDialog(this, "是否确定认输？");
            if (result == 0) {
                if (isBlack) {
                    JOptionPane.showMessageDialog(this, "黑方方已经认输，游戏结束!!!");
                } else {
                    JOptionPane.showMessageDialog(this, "白方方已经认输，游戏结束!!!");
                }
                canPlay = false;
            }
        }// 点击 关于 按钮
        if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 320
                && e.getY() <= 350) {
            JOptionPane.showMessageDialog(this,
                    "本游戏由菜鸟阿洁制作，有相关问题，可以联系本人QQ：474280917。");
        }// 点击 退出 按钮
        if (e.getX() >= 400 && e.getX() <= 470 && e.getY() >= 370
                && e.getY() <= 400) {
            JOptionPane.showMessageDialog(this, "游戏退出");
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void run() {
        // 判断是否有时间限制
        if (maxTime > 0) {
            while (true) {
                if (isBlack) {
                    blackTime--;
                    if (blackTime == 0) {
                        JOptionPane.showMessageDialog(this, "黑方超时，游戏结束!");
                    }
                } else {
                    whiteTime--;
                    if (whiteTime == 0) {
                        JOptionPane.showMessageDialog(this, "白方超时，游戏结束!");
                    }
                }
                blackMessage = blackTime / 3600 + ":"
                        + (blackTime / 60 - blackTime / 3600 * 60) + ":"
                        + (blackTime - blackTime / 60 * 60);
                whiteMessage = whiteTime / 3600 + ":"
                        + (whiteTime / 60 - whiteTime / 3600 * 60) + ":"
                        + (whiteTime - whiteTime / 60 * 60);
                this.repaint();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        FiveChessFrame mf = new FiveChessFrame();
    }

}
