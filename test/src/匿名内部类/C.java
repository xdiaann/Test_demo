package 匿名内部类;

class C {
    //成员内部类
    class B {
        public void show() {
            System.out.println("show");
        }
    }

    public void show1() {
        System.out.println("show1");
        //局部内部类
        class D {
            public void show2() {
                System.out.println("show2");
            }
        }
    }
}

class NiMing {
    public static void main(String[] args) {
        //创建对象访问对应内部类函数成员
        C c = new C();
        c.show1();

        C.B b = new C().new B();
        b.show();

    }
}
