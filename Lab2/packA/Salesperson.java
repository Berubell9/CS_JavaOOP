package packA;

import java.util.Random;

public class Salesperson extends Programmer{
    private int target; 
    public Salesperson(String n,int exp,int sal,int assignedTarget){
        //super อยู่ใน constructor classเเม่คือ Programmer
        super(n,exp,sal);
        this.target = assignedTarget;
    }
    public Salesperson(String n,int exp,int sal){
        //จะดึงมาใช้ต้องเรียก super(ตัวเเปรของเเม่);
        super(n,exp,sal);
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
    @Override
    public void setSalary(int incresedAmount){
        this.salary += incresedAmount; 
    }
    public String makeQuotation(){
        Random random = new Random();  
        int ran = random.nextInt(1000);   
        return String.format("Dear value customer, %d is my best offer.",ran);
    }
    @Override
    public String toString(){
        return String.format("Salesperson [target = %d Programmer [name = %s, salary = %d, experience = %d]]",target,super.getName(),salary,super.getExperience());
    }
}
