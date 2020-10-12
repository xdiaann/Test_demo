package 临时;

import org.junit.Test;

import java.util.*;

/**
 * @author MR.Z
 * @date 2020/8/26 1:25
 */
public class 最强蜗牛供奉周 {
    //需手动设置数据
    double 目前活动剩余天数 = 7;

    double 供奉加速_目前拥有 = 36;
    double 前置天数 = 6.5;


    int 灵能水晶_目前拥有 = 0;

    //以下是固定数据 不需要修改
    int 灵能水晶_每日礼包_100 = 100;
    int 灵能水晶_周礼包限购一次_100 = 100;
    int 灵能水晶_秩序宝箱_80_最大400 = 400;
    int 灵能水晶_中立宝箱_80_最大400 = 400;
    int 灵能水晶_混沌宝箱_80_最大400 = 400;
    int 灵能水晶_神龙宝箱_400 = 400;
    int 灵能水晶_供奉加速_6_1200 = 1200;
    List<Integer> 灵能水晶_档位所需时间List = new ArrayList<>(Arrays.asList(60, 90, 120, 150, 180, 240));
    List<Integer> 灵能水晶_供奉奖励List = new ArrayList<>(Arrays.asList(150, 150, 160, 180, 210, 250));

    @Test
    public void test01() {
        int 总计可获得灵能水晶 = 总计可获得灵能水晶();//目前最大支持249枚许愿币
        System.out.println("总计可获得灵能水晶" + 总计可获得灵能水晶);
        int 第四档 = 500 + 1000 + 1500 + 3000;
        int 第五档 = 500 + 1000 + 1500 + 3000+5000;
        System.out.println("第四档合计需要灵能水晶" + 第四档);
        System.out.println("第五档合计需要灵能水晶" + 第五档);
        System.out.println("第四档还需要灵能水晶" + (第四档 - 总计可获得灵能水晶));
        System.out.println("第五档还需要灵能水晶" + (第五档 - 总计可获得灵能水晶));

    }

    public int 总计可获得灵能水晶() {

        double 总计小时数 = 目前活动剩余天数 * 24 + 供奉加速_目前拥有 * 24+前置天数*24;
        int sum = 0;
        System.out.println("总计小时数:" + 总计小时数);
        if (总计小时数 > 240) {
            int 可完成轮次 = (int) 总计小时数 / 240;
            sum += 可完成轮次 * 1100;
            System.out.println("可完成轮次" + 可完成轮次);
            int 剩余小时数 = (int) 总计小时数 - 可完成轮次 * 240;
            System.out.println("剩余小时数" + 剩余小时数);
            总计小时数 = 剩余小时数;
        }
        int 档位 = 0;
        for (int i = 0; i < 灵能水晶_档位所需时间List.size(); i++) {   //90>=90 90>=91 ||120<91
            if (i == 5) {
                档位 = 6;
                System.out.println("档位: " + 档位);
                break;
            }
            if (总计小时数 >= 灵能水晶_档位所需时间List.get(i) && 总计小时数 < 灵能水晶_档位所需时间List.get(i + 1)) {
                档位 = i + 1;
                System.out.println("档位: " + 档位);
                break;
            }
        }
        for (int i = 0; i < 档位; i++) {

            sum += 灵能水晶_供奉奖励List.get(i);
        }

        System.out.println("供奉可获得水晶: " + sum);


        int i = (int) (灵能水晶_目前拥有 + 灵能水晶_每日礼包_100 * 目前活动剩余天数 + 灵能水晶_周礼包限购一次_100 + 灵能水晶_秩序宝箱_80_最大400
                + 灵能水晶_中立宝箱_80_最大400 + 灵能水晶_混沌宝箱_80_最大400 + 灵能水晶_神龙宝箱_400 + 灵能水晶_供奉加速_6_1200 + sum);

        return i;
    }
}
