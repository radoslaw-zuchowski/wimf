package pl.zuchol.wimf.food.exception;

public class FoodNotFoundException extends RuntimeException {

    public FoodNotFoundException(String foodName) {
        super(String.format("Food with name %s not found", foodName));
    }
}
