package app;

public class App {
    public static void main(String[] args) throws Exception {
        Employee e1 = new Employee();
        Faculty f1 = new Faculty();
        Staff s1 = new Staff();
        Employee e2 = new Employee("Salim", 500);
        Faculty f2 = new Faculty("Laila", 2000, "Lecturer");
        Staff s2 = new Staff("Maha", 1200, "Admin");
        System.out.println(e1.toString());
        System.out.println(f1.toString());
        System.out.println(s1.toString());
        System.out.println(e2.toString());
        System.out.println(f2.toString());
        System.out.println(s2.toString());
    }
}