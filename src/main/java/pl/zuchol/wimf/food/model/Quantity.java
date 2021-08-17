package pl.zuchol.wimf.food.model;

import java.util.Objects;

public class Quantity {

    private final Long value;

    private final Unit unit;

    public Quantity(Long value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Long getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return getValue().equals(quantity.getValue()) &&
                getUnit() == quantity.getUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getUnit());
    }
}
