package services;

import exceptions.AlreadyExistsException;
import exceptions.DoesNotExistException;
import models.Restaurant;
import models.User;

import java.util.*;

public class RestaurantService {
    Map<String, Restaurant> restaurants = new HashMap<>();
    Map<String, List<Restaurant>> dishToRestaurantMapping= new HashMap();
    public static RestaurantService restaurantService;

    private RestaurantService(){}
    public static RestaurantService getInstance(){
        if(restaurantService == null)
            restaurantService = new RestaurantService();
        return restaurantService;
    }
    public Restaurant addRestaurant(String restaurantName, Set<String> pincodes, String dish, Double price, int initialQty, User owner) throws AlreadyExistsException{
        if(restaurants.containsKey(restaurantName))
            throw new AlreadyExistsException("restaurant " + restaurantName + " already exists");
        Restaurant restaurant = new Restaurant(restaurantName, pincodes, dish, price, initialQty, owner);
        restaurant.setTotalRating(5);
        restaurant.setNoOfFeedbacks(1);
        restaurants.put(restaurantName, restaurant);
        if(!dishToRestaurantMapping.containsKey(dish)){
            dishToRestaurantMapping.put(dish, new ArrayList<>());
        }
        dishToRestaurantMapping.get(dish).add(restaurant);
        return restaurant;
    }
    public Restaurant getRestaurant(String name){
        return restaurants.get(name);
    }
    public void updateQty(String restaurantName, int qty) throws DoesNotExistException{
        if(!restaurants.containsKey(restaurantName))
            throw new DoesNotExistException("Could not find any restaurant with name : " + restaurantName);
        restaurants.get(restaurantName).setQty(restaurants.get(restaurantName).getQty()+qty);
    }

    public Set<Restaurant> getRestaurants(String dish, User user){
        List<Restaurant> restaurantsHavingDish = dishToRestaurantMapping.get(dish);
        Set<Restaurant> ret = new TreeSet<>((a,b) -> {
            Restaurant restaurantA = (Restaurant)a;
            Restaurant restaurantB = (Restaurant)b;
            double restaurantAAvgRating = restaurantA.getTotalRating()/restaurantA.getNoOfFeedbacks();
            double restaurantBAvgRating = restaurantB.getTotalRating()/restaurantB.getNoOfFeedbacks();
            if(restaurantAAvgRating != restaurantBAvgRating){
                return restaurantAAvgRating - restaurantBAvgRating < 0.0 ? 1 : -1;
            }else
                return restaurantA.getPrice() - restaurantB.getPrice() < 0.0 ? 1 : -1;
        });
        for(Restaurant restaurant : restaurantsHavingDish){
            if(restaurant.getServiceablePinCodes().contains(user.getPinCode()) && restaurant.getQty()-restaurant.getUserQty() > 0)
                ret.add(restaurant);
        }
        return ret;
    }
}
