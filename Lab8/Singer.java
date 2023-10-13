public class Singer {
    private String name;
    private String style;
    public Singer(String n,String style){
        this.name = n;
        this.style = style;
    }
    public String getName(){
        return name;
    }
    public String getStyle(){
        return style;
    }
    @Override
    public String toString(){
        return "Singer ("+getName()+"-SingStyle."+getStyle()+")";
    }
}
