class Food {
    String food;
    String cuisine;
    int rating;

    Food(String foods, String cuisines, int ratings) {
        this.food = foods;
        this.cuisine = cuisines;
        this.rating = ratings;
    }
}
class FoodRatings {
    Map<String, PriorityQueue<Food>> map;
    Map<String, Food> menu;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        menu = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            map.putIfAbsent(cuisines[i], new PriorityQueue<>(
                (f1, f2) -> f1.rating == f2.rating ? f1.food.compareTo(f2.food) : f2.rating - f1.rating)
            );
            PriorityQueue<Food> pq = map.get(cuisines[i]);
            Food foodObject = new Food(foods[i],cuisines[i],ratings[i]);
            pq.add(foodObject);
            menu.put(foods[i],foodObject);

        }
    }

    public void changeRating(String food, int newRating) {
        Food current = menu.get(food);
        PriorityQueue<Food> pq = map.get(current.cuisine);
        pq.remove(current);
        current.rating = newRating;
        pq.add(current);
    }

    public String highestRated(String cuisine) {
        return map.get(cuisine).peek().food;
    }
}
/**

foods : ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"]
cuisines : ["korean", "japanese", "japanese", "greek", "japanese", "korean"]
ratings : [9, 12, 8, 15, 14, 7]


foods : ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
[
  [
    ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], 
    ["korean", "japanese", "japanese", "greek", "japanese", "korean"], 
    [9, 12, 8, 15, 14, 7]
  ], 
  ["korean"], 
  ["japanese"], 
  ["sushi", 16], 
  ["japanese"], 
  ["ramen", 16], 
  ["japanese"]
]
*/
/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
