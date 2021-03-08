import sun.font.CreatedFontTracker;

public class User {
    private String userName;
    private String phoneNumber;
    private String pincode;

    public void registerUser(String userName,String phoneNumber,String pincode){
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.pincode = pincode;
    }

    public String placeOrder(String userName, String restaurantName, int rating){
        String res ="Order placed Successfully";
        return res;
    }
    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPincode() {
        return pincode;
    }

    @Override
    public String toString() {
        String str = this.userName + " "
                        + this.phoneNumber + " " + this.pincode;
        return str;
    }
}
