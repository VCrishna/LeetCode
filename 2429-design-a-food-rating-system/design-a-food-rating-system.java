class Food {
    String foodName;
    String cuisine;
    int rating;

    public Food(String food, String cuisine, int rating) {
        this.foodName = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    // foodMap
    // key : cuisisne
    // value : PriorityQueue of Food Objects (Max Heap) With max heap we can get
    // highest-rated food item for a type of cuisine in the system in constant time
    Map<String, PriorityQueue<Food>> foodMap;
    // menu
    // key : food
    // value :  Food object of the food,
    // we can get cuisine and rating of the food from food object in the map
    Map<String, Food> menu;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        menu = new HashMap<>();

        for (int i = 0; i < cuisines.length; i++) {
            if (!foodMap.containsKey(cuisines[i])) {
                foodMap.put(cuisines[i], new PriorityQueue<>(
                    (f1, f2) -> f1.rating == f2.rating ? f1.foodName.compareTo(f2.foodName) : f2.rating - f1.rating)
                );
            }
            Food foodObject = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.get(cuisines[i]).add(foodObject);
            menu.put(foods[i], foodObject);
        }
    }

    public void changeRating(String food, int newRating) {
        Food current = menu.get(food);
        PriorityQueue<Food> maxHeap = foodMap.get(current.cuisine);
        maxHeap.remove(current);
        current.rating = newRating;
        maxHeap.add(current);
    }

    public String highestRated(String cuisine) {
        return foodMap.get(cuisine).peek().foodName;
    }
}
/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
