package 游戏.牛牛;

import java.util.ArrayList;
import java.util.List;


public class BlueGame {

    private static int T;


    /**
     * @param args  
     * @author TD_LSW
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub
        BlueGame b = new BlueGame();
        ArrayList<Integer> date = new ArrayList<>();
        date.add(10);
        date.add(10);
        date.add(10);
        date.add(3);
        date.add(1);
        System.out.println(date);
        Integer integer = b._is_Blue(date, 10, 1);
        System.out.println(integer);
    }

//    private static void _blue(List<Integer> date) {
//
//            this._is_Blue(data,N,1);
//    }


    /**
     *  
     *
     * @param data 数字List
     * @param n    10
     * @param c    输出标志位
     */

    public static Integer _is_Blue(List<Integer> data, int n, int c) {
        List<Integer> result = new ArrayList<Integer>();
// TODO Auto-generated method stub
        int count = 0;
//判断是否存在0，并且存在两个0以上一定是牛十后面不需判断
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == 0) {
                count++;
                data.remove(i);
                if (count > 1) {
                    result.add(n);
                    break;
                }
            }
        }
//List中有一个0时一定有牛
        if (data.size() == 4) {
            int td = 0;
//判断是否牛十
            for (int x = 0; x < 3; x++) {
                for (int y = x + 1; y < 4; y++) {
                    if ((data.get(x) + data.get(y)) % n == 0) {
                        result.add(n);
                    } else {
                        td = getMax(data);//计算最大牛
                    }
                }
            }
//若不是牛十，则输出最大牛
            if (td < 10) {
                result.add(td);
            }
        }
//不存在0时
        if (data.size() == 5) {
            int temp = 0;
            int r = -1;//是否有牛标志
//斗牛算法
            for (int x = 0; x < 3; x++) {
                for (int y = x + 1; y < 4; y++) {
                    for (int z = y + 1; z < 5; z++) {
                        if ((data.get(x) + data.get(y) + data.get(z)) % n == 0) {
                            for (int j = 0; j < data.size(); j++) {
                                if (j != x && j != y && j != z) {
                                    temp += data.get(j);
                                }
                            }
//若有牛，且剩下的两个数也是牛十
                            if (temp % n == 0) {
                                r = n;
                            }
//若有牛，剩下的不是牛十
                            else {
                                r = temp % n;
                            }
                            result.add(r);
                        }
                    }
                }
            }
//没有牛
            if (r == -1) {
                result.add(0);
                return result.get(0);
            }
        }
//输出
        if (c == T - 1) {
            for (int p = 0; p < T; p++) {
                Integer integer = result.get(p);
                return integer;
            }
        }
        return result.get(0);
    }


    /**
     * 获得最大牛
     *
     * @param tempData
     * @return
     */
    private static int getMax(List<Integer> tempData) {
// TODO Auto-generated method stub
        int temp = (tempData.get(0) + tempData.get(1)) % 10;
        for (int n = 0; n < tempData.size() - 1; n++) {
            for (int m = n + 1; m < tempData.size(); m++) {
                if ((tempData.get(n) + tempData.get(m)) % 10 >= temp) {
                    temp = (tempData.get(n) + tempData.get(m)) % 10;
                }
            }
        }
        return temp;
    }


}
