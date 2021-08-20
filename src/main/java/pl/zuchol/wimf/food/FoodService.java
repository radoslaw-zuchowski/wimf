package pl.zuchol.wimf.food;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Service;
import pl.zuchol.wimf.food.exception.FoodNotFoundException;
import pl.zuchol.wimf.food.model.Food;

import java.util.List;

@Service
class FoodService {

    private final FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    Food createFood(Food food) {
        return repository.save(food);
    }

    public Food getFoodByName(String foodName) {
        return repository.findByName(foodName)
                .orElseThrow(() -> new FoodNotFoundException(foodName));
    }

    public List<Food> getAllFood() {
        return ImmutableList.copyOf(repository.findAll());
    }

    public void deleteFood(String foodName) {
        repository.deleteByName(foodName);
    }
}
