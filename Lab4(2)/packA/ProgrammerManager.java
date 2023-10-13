package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles{
    public ProgrammerManager(String n, int exp, int sal){
       super(n, exp, sal);
    }
    public void sayHi(){
        System.out.println("Coding in "+skills);
    }
    public String coding(){
        return "JAVA";
    }
    public int evaluate(Programmer p){
        int newSalary = p.salary + (p.salary*15)/100;
        return newSalary;
    }
}
