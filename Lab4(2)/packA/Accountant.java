package packA;

import java.util.Random;

public class Accountant extends Employee{
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;
    public Accountant(String name,int experience,int sal, int superExp ,String talent){
        super(name,experience,sal);
        this.experience = superExp;
        this.specialty = talent;
    }
    //Specialty
    public void setSpecialty(String specialty){
        this.specialty = specialty;
    }
    public String getSpecialty(){
        return specialty;
    }
    //AccountExperience
    public void setAccountExperience(int experience){
        this.experience = experience;
    }
    public int getAccountExperience(){
        return experience;
    }
    public String tellProfit(){
        Random random = new Random();
        int ran = random.nextInt(1000);
        return String.format("%s's profit is %d. My salary is %d",companyName,ran,salary);
    }
    @Override
    public String toString(){
        return String.format("%s %d %d can %s",name,experience,experience,specialty);
    }
    public void sayHi(){
        System.out.println(name+" say Hi si");
    }
    public static String tellMyRole(){
        return String.format("I am an accountant at "+companyName);
    }
}
