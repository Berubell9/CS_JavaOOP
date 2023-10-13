package OOP;
import java.util.ArrayList; 
class Lab1Coder{
    private String name;
    int experience;
    ArrayList<String> languages = new ArrayList<String>();
    Lab1Coder(String n,int exp){
        name = n;
        experience = exp;
    }
    Lab1Coder(String n){
        this.name = n;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }
    public int getExperience(){
        return experience;
    }
    public void setLanguage(String ...langs){
        // for (int i = 0; i < langs.length; i++)
        // {
        //     languages.add(langs[i]);
        // }
        for (String i:langs)
        {
            languages.add(i);
        }
    }
    public ArrayList<String> getLanguages(){
        return languages;
    }
    public String toString(){
        String str = String.format("%s(%d) knows",name,experience);
        for(String s : languages){
            str+=" "+s;
        }
        return str;
    }
    public ArrayList<String> findCommonLanguages(Lab1Coder other){
        ArrayList<String> temp = new ArrayList<>();
        for (String lan1: languages) {
            for (String otherLang : other.getLanguages()) {
                if(lan1.equals(otherLang)){
                    temp.add(lan1);
                }
            }
        }
        if(temp.size() == 0){
            temp.add("none");
        }
        return temp;
    }
    
}