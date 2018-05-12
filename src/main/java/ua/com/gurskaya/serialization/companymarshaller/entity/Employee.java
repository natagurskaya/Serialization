package ua.com.gurskaya.serialization.companymarshaller.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
@XmlType(propOrder = { "id", "name", "salary", "birth"}, name = "employee")
public class Employee {
    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private double salary;
    @XmlElement
    private LocalDate birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", birth=" + birth +
                '}';
    }
}
