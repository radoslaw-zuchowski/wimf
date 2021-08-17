package pl.zuchol.wimf.food.msg;

import pl.zuchol.wimf.food.model.Unit;

public class QuantityDto {

    private Long value;

    private Unit unit;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
