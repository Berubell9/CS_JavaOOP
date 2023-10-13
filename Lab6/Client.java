public class Client implements CanPay{
    private String name;
    private MemberTypeWithDiscount memberType;

    public Client(String name){
        this.name = name;
        memberType = MemberTypeWithDiscount.None;
    }
    //implement มาจาก interface
    @Override
    public void spend(int direction){
        if(direction > 0){ //1
            promoteMemberType();
        }else{ //-1
            demoteMemberType();
        }
    }
    private void promoteMemberType(){
        if(memberType == MemberTypeWithDiscount.None){
            memberType = MemberTypeWithDiscount.SILVER;
        }
        else if(memberType == MemberTypeWithDiscount.SILVER){
            memberType = MemberTypeWithDiscount.GOLD;
        }
        else if(memberType == MemberTypeWithDiscount.GOLD){
            memberType = MemberTypeWithDiscount.PREMIUM;
        }
        showMembershipStatus();
    }
    private void demoteMemberType(){
        if(memberType == MemberTypeWithDiscount.PREMIUM){
            memberType = MemberTypeWithDiscount.GOLD;
        }
        else if(memberType == MemberTypeWithDiscount.GOLD){
            memberType = MemberTypeWithDiscount.SILVER;
        }
        else if(memberType == MemberTypeWithDiscount.SILVER){
            memberType = MemberTypeWithDiscount.SILVER;
        }
        showMembershipStatus();
    }
    public void showMembershipStatus(){
        System.out.println("You are now "+memberType+" "+(int)memberType.getProductDiscount()+"% discount on Product "+(int)memberType.getServiceDiscount()+"% on service");
    }
}
