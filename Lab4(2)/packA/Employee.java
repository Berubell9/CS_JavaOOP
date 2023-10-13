package packA;
//abstract
public abstract class Employee {
    protected String name;
    protected int experience;
    protected int salary;
    public Employee(String n, int exp, int sal){
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }
    public abstract void sayHi();
}
