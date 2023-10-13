package packA;

public class EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;
    
    public EmpTmp(String n, int exp, int sal){
        this.name = n;
        this.experience = exp;
        this.salary = sal;
    }
    public EmpTmp(String n){
        this.name = n;
    }
    public EmpTmp(){
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
