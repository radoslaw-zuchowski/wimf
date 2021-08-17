package pl.zuchol.wimf.food;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.zuchol.wimf.food.model.Food;

interface FoodRepository extends PagingAndSortingRepository<Food, String> {
}
