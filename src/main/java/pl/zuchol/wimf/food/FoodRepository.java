package pl.zuchol.wimf.food;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.zuchol.wimf.food.model.Food;

import java.util.Optional;

interface FoodRepository extends PagingAndSortingRepository<Food, String> {

    Optional<Food> findByName(String foodName);

    void deleteByName(String foodName);
}
