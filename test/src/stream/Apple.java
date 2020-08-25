package stream;

import lombok.Data;

/**
 * @author MR.Z
 * @date 2020/5/11 10:54
 */
@Data
public class Apple {

    int i = 0;
    String abc = null;

    Apple eatApple() {
        i++;
        return this;
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple);
        System.out.println(apple.eatApple().eatApple().toString());
    }
}

