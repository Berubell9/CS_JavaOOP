package packA;

import java.util.ArrayList;

public class Programmer extends Employee{
    protected ArrayList<String> skills;
    
    public Programmer(String name, int experience, int salary){
        super(name,experience,salary);
        skills = new ArrayList<>();
        skills.add("solidity");
        skills.add("typescript");
    }
    @Override
    public void sayHi(){
        System.out.println("hi from "+name);
    }
    @Override
    public String toString(){
        return String.format("ManagerProgrammer [name = %s ,experience = %d ,salary = %d ]",name,experience,salary);
    }
    public String coding(){
        return "JAVA";
    }
}
