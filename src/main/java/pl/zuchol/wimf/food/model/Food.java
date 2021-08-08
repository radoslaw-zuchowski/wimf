package pl.zuchol.wimf.food.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("foods")
public class Food {

    @Id
    private final String id;

    private final String name;

    private final Quantity quantity;

    public Food(String id, String name, Quantity quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return getId().equals(food.getId()) && getName().equals(food.getName()) && getQuantity().equals(food.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getQuantity());
    }
}
