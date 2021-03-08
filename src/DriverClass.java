import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverClass {


    public static void main(String[] args) {

        RestaurantService restaurantService = RestaurantService.getInstance();
        restaurantService.registerUser("Nitesh", "phoneNumber-1", "HSR");
        restaurantService.registerUser("Ravi", "phoneNumber-1", "HSR");
        restaurantService.registerUser("Ashutosh", "phoneNumber-1", "HSR");


        List<String> serviceblePincode = new ArrayList<>();
        serviceblePincode.add("BTM");
        serviceblePincode.add("HSR");
        restaurantService.registerRestaurant("Food Court-1", serviceblePincode, "NI Thali", 100, 10);
        restaurantService.registerRestaurant("Food Court-2", serviceblePincode, "Burger", 120, 101);
        restaurantService.registerRestaurant("Food Court-3", serviceblePincode, "SI Thali", 50, 123);

        String orderStatus = restaurantService.placeOrder("Nitesh", "Food Court-1", 2);
        System.out.println("OrderStatus : " + orderStatus);

        orderStatus = restaurantService.placeOrder("Ravi", "Food Court-1", 2);
        System.out.println("OrderStatus : " + orderStatus);

        orderStatus = restaurantService.placeOrder("Ashutosh", "Food Court-1", 2);
        System.out.println("OrderStatus : " + orderStatus);

        orderStatus = restaurantService.placeOrder("Ashutosh", "Food Court-1", 300);
        System.out.println("OrderStatus : " + orderStatus);

        orderStatus = restaurantService.placeOrder("Nitesh", "Food Court-2", 2);
        System.out.println("OrderStatus : " + orderStatus);
        orderStatus = restaurantService.placeOrder("Ravi", "Food Court-2", 2);
        System.out.println("OrderStatus : " + orderStatus);
        orderStatus = restaurantService.placeOrder("Ashutosh", "Food Court-2", 2);
        System.out.println("OrderStatus : " + orderStatus);

        orderStatus = restaurantService.placeOrder("Ashutosh", "Food Court-2", 214);
        System.out.println("OrderStatus : " + orderStatus);

        orderStatus = restaurantService.placeOrder("Ashutosh", "Food Court-3", 214);
        System.out.println("OrderStatus : " + orderStatus);


        String review = restaurantService.createReview("Nitesh", "Food Court-2", 2);
        System.out.println("review : " + review);
        review = restaurantService.createReview("Ravi", "Food Court-2", 2);
        System.out.println("review : " + review);
        review = restaurantService.createReview("Ashutosh", "Food Court-2", 2);
        System.out.println("review : " + review);


        review = restaurantService.createReview("Nitesh", "Food Court-1", 3);
        System.out.println("review : " + review);
        review = restaurantService.createReview("Ravi", "Food Court-1", 3);
        System.out.println("review : " + review);
        review = restaurantService.createReview("Ashutosh", "Food Court-1", 3);
        System.out.println("review : " + review);

        restaurantService.showRestaurant(2);
        restaurantService.showRestaurant(3);

        restaurantService.updateQuantity("Food Court-1", 0);

        orderStatus = restaurantService.placeOrder("Nitesh", "Food Court-1", 2);
        System.out.println("OrderStatus : " + orderStatus);

        System.out.println(restaurantService.getRating("Food Court-1"));
        System.out.println(restaurantService.getRating("Food Court-"));

    }
}
