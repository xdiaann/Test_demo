package List.并发修改异常;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-12 11:11
 */
public class TestConcurrentModificationException {
    @Test
    public void test() {
        this.listRemove3();
    }

    /**
     * 使用增强的for循环
     * 在循环过程中从List中删除元素以后，继续循环List时会报ConcurrentModificationException
     */
    public void listRemove() {
        List<Student> students = this.getStudents();
        for (Student stu : students) {
            if (stu.getId() == 2)
                students.remove(stu);
        }
    }

    /**
     * 这种遍历有可能会遗漏某个元素,因为删除元素后List的size在
     * 变化，元素的索引也在变化，比如你循环到第2个元素的时候你把它删了，
     * 接下来你去访问第3个元素，实际上访问到的是原先的第4个元素。当访问的元素
     * 索引超过了当前的List的size后还会出现数组越界的异常，当然这里不会出现这种异常，
     * 因为这里每遍历一次都重新拿了一次当前List的size。
     */
    public void listRemove2() {
        List<Student> students = this.getStudents();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == 2) {
                students.remove(i);
            }
        }
        System.out.println("之后: " + students);
    }

    /**
     * 像这种使用增强的for循环对List进行遍历删除，但删除之后马上就跳出的也不会出现异常
     */
    public void listRemoveBreak() {
        List<Student> students = this.getStudents();
        for (Student stu : students) {
            if (stu.getId() == 2) {
                students.remove(stu);
                break;
            }
        }
    }

    /**
     * 使用Iterator的方式也可以顺利删除和遍历
     */
    public void iteratorRemove(){
        List<Student> students = this.getStudents();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student next = it.next();
            if (next.getId() == 2) {
                it.remove();
            }
        }
        System.out.println(students);
    }

    public void listRemove3() {
        List<Student> students = this.getStudents();
        //循环中删除不报错
        for(Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ){
            iterator.remove();
        }
        System.out.println(students);
    }

    public void iteratorRemoveLambda() {
        List<Student> students = this.getStudents();
        //这里要使用Iterator的remove方法移除当前对象，如果使用List的remove方法，则同样会出现ConcurrentModificationException
        students.removeIf(student -> student.getId() % 2 == 0);
        System.out.println(students);
    }

    private List<Student> getStudents() {
        List<Student> students = new ArrayList<Student>() {
            {
                int i = 0;
                while (i++ < 5) {
                    Student student = new Student(i, "201200" + i, "name_" + i);
                    this.add(student);
                }
            }
        };
        System.out.println("之前：" + students);
        return students;
    }
}



