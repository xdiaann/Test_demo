package 其他.文件重命名;


import java.io.File;

//重命名
public class FileReName {
    static String path = "G:\\哲学\\小说\\色 小说 全集10000篇\\情色小说全集";

    public static void printDir(File file) {
        //获取子文件和目录
        File[] files = file.listFiles();
        for (File f : files) {
            //判断是文档还是目录
            if (f.isFile()) {
                //判断是不是文件，如果是文件，就输出文件路径
//                System.out.println("文件名：" + f.getAbsolutePath());
                if (f.getName().startsWith("合集】")) {
//                System.out.println(fileName[i]);
                    //-------------这里是你想要对旧名字进行的操作，这里我只是做了一个简单的截取---------------
                    String newName = f.getName().substring(3);//修改新名字为从第四个字符之后的内容
                    boolean b = f.renameTo(new File(path + newName));
                    System.out.println(f.getName()+" "+b +" "+newName);
                }
            } else {
                //代表是目录，同样也输出目录绝对路径
//                System.out.println("目录" + f.getAbsolutePath());
                //继续变能力，访问目录下的子文件和子目录，递归调用
                printDir(f);
            }
        }
    }

    public static void main(String[] args) {

        File file = new File(path);

        //需递归查找 独立方法
        printDir(file);

    }
}
