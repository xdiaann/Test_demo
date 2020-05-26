package 牛牛;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * "*"@author"：luoxiang
 * "*"@description：
 * "*"@date"：2020/5/17"15:32
 * "
 */
public class NiuNiu {
    private static Map<Integer, String> hashMap = new HashMap<>();
    private static Integer flag=0;

    static {
        shufflePoker();
    }

    public static void initMap() {
        shufflePoker();
    }

    public static List getPoker() {
        ArrayList<String> pokers = new ArrayList<>();
        if (hashMap.size()<30){
            initMap();
        }
        for (int i = 0; i < 5; i++) {
            Integer index = (int) (1 + Math.random() * (52 - 1 + 1));
            String poker = hashMap.get(index);
            if (poker != null) {
                pokers.add(poker);
                hashMap.remove(index);
            } else {
                i--;
                continue;
            }
        }
        return pokers;
    }

    public static Integer ready(){
        flag+=1;
        return flag;
    }

    public static void shufflePoker(){
        hashMap.put(1, "♠A,1");
        hashMap.put(2, "♠2,2");
        hashMap.put(3, "♠3,3");
        hashMap.put(4, "♠4,4");
        hashMap.put(5, "♠5,5");
        hashMap.put(6, "♠6,6");
        hashMap.put(7, "♠7,7");
        hashMap.put(8, "♠8,8");
        hashMap.put(9, "♠9,9");
        hashMap.put(10, "♠10,10");
        hashMap.put(11, "♠J,10");
        hashMap.put(12, "♠Q,10");
        hashMap.put(13, "♠K,10");

        hashMap.put(14, "♥A,1");
        hashMap.put(15, "♥2,2");
        hashMap.put(16, "♥3,3");
        hashMap.put(17, "♥4,4");
        hashMap.put(18, "♥5,5");
        hashMap.put(19, "♥6,6");
        hashMap.put(20, "♥7,7");
        hashMap.put(21, "♥8,8");
        hashMap.put(22, "♥9,9");
        hashMap.put(23, "♥10,10");
        hashMap.put(24, "♥J,10");
        hashMap.put(25, "♥Q,10");
        hashMap.put(26, "♥K,10");

        hashMap.put(27, "♦A,1");
        hashMap.put(28, "♦2,2");
        hashMap.put(29, "♦3,3");
        hashMap.put(30, "♦4,4");
        hashMap.put(31, "♦5,5");
        hashMap.put(32, "♦6,6");
        hashMap.put(33, "♦7,7");
        hashMap.put(34, "♦8,8");
        hashMap.put(35, "♦9,9");
        hashMap.put(36, "♦10,10");
        hashMap.put(37, "♦J,10");
        hashMap.put(38, "♦Q,10");
        hashMap.put(39, "♦K,10");

        hashMap.put(40, "♣A,1");
        hashMap.put(41, "♣2,2");
        hashMap.put(42, "♣3,3");
        hashMap.put(43, "♣4,4");
        hashMap.put(44, "♣5,5");
        hashMap.put(45, "♣6,6");
        hashMap.put(46, "♣7,7");
        hashMap.put(47, "♣8,8");
        hashMap.put(48, "♣9,9");
        hashMap.put(49, "♣10,10");
        hashMap.put(50, "♣J,10");
        hashMap.put(51, "♣Q,10");
        hashMap.put(52, "♣K,10");
    }
}
