// A simple class to hold information about a food item
class Food {
    String foodName; // name of the food
    String cuisine; // cuisine type (e.g., "Italian", "Mexican")
    int rating; // current rating of this food

    // constructor to initialize fields
    public Food(String food, String cuisine, int rating) {
        this.foodName = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    // foodMap
    // key : cuisine name (e.g., "Italian")
    // value : Max Heap (PriorityQueue) of Food objects for that cuisine
    // Max Heap ordering:
    //   1. Higher rating first
    //   2. If tie, lexicographically smaller food name first
    Map<String, PriorityQueue<Food>> foodMap;

    // menu
    // key : food name
    // value : Food object reference
    // Purpose: Quickly find a food’s cuisine and rating to update
    Map<String, Food> menu;

    // Constructor
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        menu = new HashMap<>();

        // Build data structures
        for (int i = 0; i < cuisines.length; i++) {
            // If this cuisine hasn’t been seen before, initialize a new heap
            if (!foodMap.containsKey(cuisines[i])) {
                foodMap.put(cuisines[i], new PriorityQueue<>(
                        // custom comparator: highest rated first, break ties by name
                        (f1, f2) -> f1.rating == f2.rating
                                ? f1.foodName.compareTo(f2.foodName)
                                : f2.rating - f1.rating));
            }

            // Create a Food object for this food
            Food foodObject = new Food(foods[i], cuisines[i], ratings[i]);

            // Add it to that cuisine’s heap
            foodMap.get(cuisines[i]).add(foodObject);

            // Add it to the global menu for quick lookups
            menu.put(foods[i], foodObject);
        }
    }

    // Update the rating of a given food
    public void changeRating(String food, int newRating) {
        // Get the Food object from menu
        Food current = menu.get(food);

        // Find which cuisine heap it belongs to
        PriorityQueue<Food> maxHeap = foodMap.get(current.cuisine);

        // Remove old version from heap
        maxHeap.remove(current);

        // Update rating
        current.rating = newRating;

        // Add back with updated rating (heap will reorder)
        maxHeap.add(current);
    }

    // Query: get the highest-rated food in a cuisine
    public String highestRated(String cuisine) {
        // Peek at heap top → always the best candidate
        return foodMap.get(cuisine).peek().foodName;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */