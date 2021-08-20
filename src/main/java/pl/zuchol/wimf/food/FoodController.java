package pl.zuchol.wimf.food;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zuchol.wimf.food.msg.FoodDto;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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
    public ResponseEntity<FoodDto> create(@RequestBody FoodDto foodDto) {
        var food = foodService.createFood(foodMapper.toModel(foodDto));
        return new ResponseEntity<>(foodMapper.toDto(food), CREATED);
    }

    @GetMapping("/{foodName}")
    public ResponseEntity<FoodDto> get(@PathVariable String foodName) {
        var food = foodService.getFoodByName(foodName);
        return new ResponseEntity<>(foodMapper.toDto(food), OK);
    }

    @GetMapping
    public ResponseEntity<List<FoodDto>> getAll() {
        var foods = foodService.getAllFood();
        final var list = foods.stream()
                .map(foodMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, OK);
    }

}
