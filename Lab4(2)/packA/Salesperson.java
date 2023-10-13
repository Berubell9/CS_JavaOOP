package packA;

import java.util.Random;

public class Salesperson extends Employee implements SalesRoles{
    private int target; 
    public Salesperson(String name,int exp,int sal,int assignedTarget){
        super(name,exp,sal);
        this.target = assignedTarget;
    }
    public Salesperson(String name,int exp,int sal){
        super(name,exp,sal);
    }
    //target
    public void setTarget(int target){
        this.target = target;
    }
    public int getTarget(){
        return target;
    }
    //Salary
    public void setSalary(){
        this.salary += (this.salary*10)/100; 
    }
    public void setSalary(int incresedAmount){
        this.salary += incresedAmount; 
    }
    public String makeQuotation(){
        Random random = new Random();  
        int ran = random.nextInt(1000);   
        return String.format("Dear value customer, %d is my best offer.",ran);
    }
    public void sayHi(){
        System.out.println("Say Hi "+name);
    }
    /*@Override
    public String toString(){
        return String.format("Salesperson [target = %d Programmer [name = %s, salary = %d, experience = %d]]",target,super.getName(),salary,super.getExperience());
    }*/
}
