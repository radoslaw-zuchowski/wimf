package pl.zuchol.wimf.food;

import org.springframework.stereotype.Service;
import pl.zuchol.wimf.food.model.Food;

@Service
class FoodService {

    private final FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    Food createFood(Food food) {
        return repository.save(food);
    }
}
