package app;

import java.util.Scanner;

class Employee {
    public String name;
    private double salary;

    public Employee() {
        Scanner in = new Scanner(System.in);
        System.out.println("Plz enter name: ");
        name = in.next();
        System.out.println("Plz enter salary: ");
        salary = in.nextDouble();
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Name is: " + name + "  Salary: " + salary;
    }
}

class Faculty extends Employee {
    public String rank;

    public Faculty() {
        Scanner in = new Scanner(System.in);
        System.out.println("Plz enter rank: ");
        rank = in.next();
    }

    public Faculty(String name, double salary, String rank) {
        super(name, salary);
        this.name = name;
        this.setSalary(salary);
        this.rank = rank;
    }

    public String toString() {
        return super.toString() + "  Rank: " + rank;

    }
}

class Staff extends Employee {
    public String title;

    public Staff() {
        Scanner in = new Scanner(System.in);
        System.out.println("Plz enter title: ");
        title = in.next();
    }

    public Staff(String name, double salary, String title) {
        super(name, salary);
        this.name = name;
        this.setSalary(salary);
        this.title = title;
    }

    public String toString() {
        return super.toString() + "  Title: " + title;
    }
}