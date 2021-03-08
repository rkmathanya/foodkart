import java.util.List;

public class Restaurant {
    private String resturantName;
    private List<String> listServiceablePincodes;
    private String foodItemName;
    private int foodItemPrice;
    private int initialQuantity;

    private int resRating = 0;
    private int totalRating = 0;
    private int totalRatingCount = 0;

    public void registerRestaurant(String resturantName,List<String>listServiceablePincodes,String foodItemName
                                        ,int foodItemPrice, int initialQuantity){
        this.resturantName = resturantName;
        this.listServiceablePincodes = listServiceablePincodes;
        this.foodItemName = foodItemName;
        this.foodItemPrice = foodItemPrice;
        this.initialQuantity = initialQuantity;
    }

    public void giveRating(int rating){
        this.totalRating += rating;
        this.totalRating++;
        resRating = totalRating/totalRatingCount;
    }

    public int getResRating() {
        return resRating;
    }

    @Override
    public String toString() {
        String str = this.resturantName + " "
                + this.foodItemName + " " + this.foodItemPrice + " " + this.initialQuantity;
        return str;
    }

    public String getResturantName() {
        return resturantName;
    }

    public List<String> getListServiceablePincodes() {
        return listServiceablePincodes;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public int getFoodItemPrice() {
        return foodItemPrice;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setResturantName(String resturantName) {
        this.resturantName = resturantName;
    }

    public void setListServiceablePincodes(List<String> listServiceablePincodes) {
        this.listServiceablePincodes = listServiceablePincodes;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public void setFoodItemPrice(int foodItemPrice) {
        this.foodItemPrice = foodItemPrice;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public void setResRating(int resRating) {
        this.resRating = resRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public void setTotalRatingCount(int totalRatingCount) {
        this.totalRatingCount = totalRatingCount;
    }
}