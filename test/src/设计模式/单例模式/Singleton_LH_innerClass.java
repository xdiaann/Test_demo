package 设计模式.单例模式;

/**
 * @author MR.Z
 * @date 2020/6/23 1:42
 */
public class Singleton_LH_innerClass {
    private Singleton_LH_innerClass() {

    }

    private static class Inner {
        private static final Singleton_LH_innerClass SINGLETON_LH_INNER_CLASS = new Singleton_LH_innerClass();
    }

    public static Singleton_LH_innerClass getInstance() {

        return Inner.SINGLETON_LH_INNER_CLASS;
    }
}
