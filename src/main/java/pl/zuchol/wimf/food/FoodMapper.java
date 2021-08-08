package pl.zuchol.wimf.food;

import org.springframework.stereotype.Component;
import pl.zuchol.wimf.food.model.Food;
import pl.zuchol.wimf.food.model.Quantity;
import pl.zuchol.wimf.food.msg.FoodDto;
import pl.zuchol.wimf.food.msg.QuantityDto;

@Component
public class FoodMapper {

    public Food toModel(FoodDto foodDto) {
        return new Food(
                foodDto.getId(),
                foodDto.getName(),
                mapToQuantity(foodDto.getQuantity())
        );
    }

    public FoodDto toDto(Food food) {
        final var foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        foodDto.setQuantity(mapToQuantityDto(food.getQuantity()));
        return foodDto;
    }

    private Quantity mapToQuantity(QuantityDto quantityDto) {
        return new Quantity(
                quantityDto.getValue(),
                quantityDto.getUnit()
        );
    }

    private QuantityDto mapToQuantityDto(Quantity quantity) {
        final var quantityDto = new QuantityDto();
        quantityDto.setValue(quantity.getValue());
        quantityDto.setUnit(quantity.getUnit());
        return quantityDto;
    }
}
