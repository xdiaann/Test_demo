package 临时;

import lombok.Data;


public class test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge("1");
        student.eat();

    }
}


@Data
class Student {
    private  String name;
    private  String age;

    public void eat() {

        System.out.println(age+"吃饭");
    }



}

