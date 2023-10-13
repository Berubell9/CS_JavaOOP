public class Customer implements CanPay{
    private String name;
    private MemberType memberType; 

    public Customer(String name){
        this.name = name;
        memberType = MemberType.None; //memberType เริ่มต้น 
    }
    
    @Override
    public void spend(int direction) {
        if (direction > 0) //1
            promoteMemberType();
        else{ //-1
            demoteMemberType();
        }
    }
    private void promoteMemberType(){
        if(memberType == MemberType.None){
            memberType = MemberType.SILVER;
        }
        else if(memberType == MemberType.SILVER){
            memberType = MemberType.GOLD;
        }
        else if(memberType == MemberType.GOLD) {
            memberType = MemberType.PREMIUM;
        }
        showMembershipStatus();
    }
    private void demoteMemberType(){
        if(memberType == MemberType.PREMIUM){
            memberType = MemberType.GOLD;
        }
        else if(memberType == MemberType.GOLD){
            memberType = MemberType.SILVER;
        }
        else if(memberType == MemberType.SILVER){
            memberType = MemberType.SILVER;
        }
        showMembershipStatus();
    }
    public void showMembershipStatus(){
        System.out.println("You are now " + memberType);
    }
}