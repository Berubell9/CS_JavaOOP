class stream{
    enum Gender{
        male,female;   
    }
    private int sequence; //ลำดับ
    private String name;
    private int age;
    private Gender sex;
    //constructor
    public stream(int no,String name,int age,Gender sex){
        this.sequence = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public int getNo(){
        return sequence;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public Gender getSex(){
        return sex;
    }

}