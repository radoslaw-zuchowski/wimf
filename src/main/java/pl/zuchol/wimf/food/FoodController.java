package pl.zuchol.wimf.food;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zuchol.wimf.food.msg.FoodDto;

@RestController
@RequestMapping("/foods")
class FoodController {

    private final FoodService foodService;

    private final FoodMapper foodMapper;

    public FoodController(
            FoodService foodService,
            FoodMapper foodMapper
    ) {
        this.foodService = foodService;
        this.foodMapper = foodMapper;
    }

    @PostMapping
    private FoodDto create(@RequestBody FoodDto foodDto) {
        var food = foodService.createFood(foodMapper.toModel(foodDto));
        return foodMapper.toDto(food);
    }
}
