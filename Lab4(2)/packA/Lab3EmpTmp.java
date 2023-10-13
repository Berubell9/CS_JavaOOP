package packA;

public class Lab3EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;
    
    public Lab3EmpTmp(String n, int exp, int sal){
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }
    public Lab3EmpTmp(String n){
        this.name = n;
    }
    public Lab3EmpTmp(){
        this("",0,0);
    }
    //Name
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //Salary
    public void setSalary(int newSalary){
        this.salary = newSalary;
    }
    public int getSalary(){
        return salary;
    }
    //experience
    public void setExperience(int exp){
        this.experience = exp;
    }
    public int getExperience(){
        return experience;
    }
    @Override
    public String toString(){
        return String.format("Programmer [name = %s, salary = %d, experience = %d]",name,salary,experience);
    }
    public void sayHi(){
        System.out.println("hi from "+name);
    }
}
