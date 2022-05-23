package lpnu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza {

    private Long id;
    private String name;
    private Double totalPrice;
    private List<AddsToPizza> adds = new ArrayList<>();

    public Pizza() {
    }

    public Pizza(Long id, String name, Double totalPrice, List<AddsToPizza> adds) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.adds = adds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<AddsToPizza> getAdds() {
        return adds;
    }

    public void setAdds(List<AddsToPizza> adds) {
        this.adds = adds;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", adds=" + adds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(name, pizza.name) && Objects.equals(totalPrice, pizza.totalPrice) && Objects.equals(adds, pizza.adds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalPrice, adds);
    }
}
