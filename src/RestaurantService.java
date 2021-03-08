import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {

    private static RestaurantService restaurantService = null;

    public Map<String, Restaurant> restaurantMap = new HashMap<>();
    public Map<String, User> userMap = new HashMap<>();
    public Map<String, List<String>> userRest = new HashMap<String, List<String>>();

    public static RestaurantService getInstance() {
        if (restaurantService != null)
            return restaurantService;
        restaurantService = new RestaurantService();
        return restaurantService;
    }

    public void registerUser(String userName, String phoneNumber, String pincode) {
        User user = new User();
        user.registerUser(userName, phoneNumber, pincode);
        userMap.put(userName, user);
    }

    public void registerRestaurant(String resturantName, List<String> listServiceablePincodes, String foodItemName
            , int foodItemPrice, int initialQuantity) {
        Restaurant restaurant = new Restaurant();
        restaurant.registerRestaurant(resturantName, listServiceablePincodes, foodItemName, foodItemPrice, initialQuantity);
        restaurantMap.put(resturantName, restaurant);
    }

    public String placeOrder(String userName, String restaurantName, int quantity) {
        String res = "";
        if (!restaurantMap.containsKey(restaurantName)) {
            res = "Cannot place order";
            return res;
        }
        Restaurant restaurant = restaurantMap.get(restaurantName);
        int availableQuant = restaurant.getInitialQuantity();
        if (availableQuant < quantity) {
            res = "Cannot place order";
            return res;
        }
        restaurant.setInitialQuantity(availableQuant - quantity);
        restaurantMap.put(restaurantName, restaurant);

        List<String> str = userRest.get(userName);
        if (str == null) {
            str = new ArrayList<>();
        }
        System.out.println("listSize : " + str.size());
        str.add(restaurantName);
        userRest.put(userName, str);
        res = "Order Placed Successfully";
        return res;
    }

    public String createReview(String userName, String restaurantName, int rating) {
        String res = "";
        List<String> restList = userRest.get(userName);
        boolean isUserOrdered = false;
        for (String resName : restList) {
            System.out.println("resName:" + resName);
            if (resName.equalsIgnoreCase(restaurantName)) {
                isUserOrdered = true;
            }
        }
        System.out.println("restaurantName : " + restaurantName);
        if (!isUserOrdered) {
            res = "can't post a review, without ordering";
            return res;
        }
        Restaurant restaurant = restaurantMap.get(restaurantName);
        restaurant.setResRating(rating);
        res = "rating posted successfully";
        return res;
    }

    public Map<String, Restaurant> getRestaurantMap() {
        return restaurantMap;
    }

    public void setRestaurantMap(Map<String, Restaurant> restaurantMap) {
        this.restaurantMap = restaurantMap;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void showRestaurant(int restRating) {
        for (Map.Entry<String, Restaurant> restaurantEntry : restaurantMap.entrySet()) {
            Restaurant restaurant = restaurantEntry.getValue();
            if (restaurant.getResRating() == restRating) {
                System.out.println(restaurant.toString());
            }
        }
    }

    public void updateQuantity(String restaurantName, int quantity) {
        Restaurant restaurant = restaurantMap.get(restaurantName);
        restaurant.setInitialQuantity(quantity);
        System.out.println("updated quantity : " + restaurant.getInitialQuantity());
        restaurantMap.put(restaurantName, restaurant);
    }

    public int getRating(String restaurentName) {
        Restaurant restaurant = restaurantMap.get(restaurentName);
        if(restaurant==null){
            System.out.println("restaurant does not exist");
            return -1;
        }
        int rating = restaurant.getResRating();
        return rating;
    }
}
