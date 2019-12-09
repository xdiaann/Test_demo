package List.并发修改异常;

/**
 * @description:
 * @author: Mr.Z
 * @create: 2019-04-12 11:13
 */
public class Student {

        private int id;
        private String stuNo;
        private String name;

        public Student() {

        }

        public Student(int id, String stuNo, String name) {
            this.id = id;
            this.stuNo = stuNo;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStuNo() {
            return stuNo;
        }

        public void setStuNo(String stuNo) {
            this.stuNo = stuNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + ", stuNo=" + stuNo
                    + "]";
        }

    }
