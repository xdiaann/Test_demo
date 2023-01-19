package 临时;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Employee {

    private String name;
    private int number;
    private MyData birthday;

    abstract double earnings();
}

@Data
@AllArgsConstructor
class MyData {
    private int year;
    private int month;
    private int day;

    public String toDateString() {
        return year + "年" + month + "月" + day + '日';
    }
}

@Data
class SalariedEmployee extends Employee {
    private int monthlySalary;

    public SalariedEmployee(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(String name, int number, MyData birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double earnings() {
        return monthlySalary;
    }

    public String toString() {
        return "SalariedEmployee : " + super.toString();
    }
}


class HourlyEmployee extends Employee {
    private int wage;//每小时的工资
    private int hour;//月工作的小时数

    public HourlyEmployee(String name, int number, MyData birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    double earnings() {
        return wage*hour;
    }

    public String toString() {
        return "HourlyEmployee : " + super.toString();
    }
}

class PayrollSystem {
    public static void main(String[] args) {


        Employee[] employees = new Employee[2];
        employees[0] = new SalariedEmployee("11", 1000, new MyData(1992, 1, 1),10000);
        employees[1] = new HourlyEmployee("22", 1001, new MyData(1992, 5, 2),60,240);

        for (Employee employee : employees) {
            System.out.println(employee);
            System.out.println(employee.earnings());
        }
    }

}

