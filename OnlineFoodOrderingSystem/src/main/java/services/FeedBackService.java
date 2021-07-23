package services;

import exceptions.DoesNotExistException;
import models.FeedBack;
import models.Restaurant;
import models.User;

import java.util.HashMap;
import java.util.Map;

public class FeedBackService {
    Map<String, FeedBack> feedbacks = new HashMap<>();
    public static FeedBackService feedBackService;
    private FeedBackService(){}
    public static FeedBackService getInstance(){
        if(feedBackService == null)
            feedBackService = new FeedBackService();
        return feedBackService;
    }
    public FeedBack rateRestaurant(String restaurantName, String userName, int rating, String comment) throws DoesNotExistException{
        Restaurant restaurant = RestaurantService.getInstance().getRestaurant(restaurantName);
        if(restaurant == null)
            throw new DoesNotExistException("no restaurant exists with name " + restaurantName);
        User user = UserService.getInstance().getUser(userName);
        if(user == null)
            throw new DoesNotExistException("no user exists with name " + userName);
        FeedBack feedBack = new FeedBack(restaurant, user, comment,rating);
        feedbacks.put(restaurantName, feedBack);
        restaurant.setTotalRating(restaurant.getTotalRating()+rating);
        restaurant.setNoOfFeedbacks(restaurant.getNoOfFeedbacks()+1);
        return feedBack;
    }
}
