package 实现和继承Demo.abcde;

public class A extends B {


    public A(D d) {
        super(d);
    }

    @Override
    public String toString() {
        return "A{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

}
