package lpnu.entity;

import lpnu.entity.enumeration.SizeOfDrinks;

import java.util.Objects;

public class Drinks {

    private Long id;
    private String name;
    private Double price;
    private SizeOfDrinks size;

    public Drinks() {
    }

    public Drinks(Long id, String name, Double price, SizeOfDrinks size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SizeOfDrinks getSize() {
        return size;
    }

    public void setSize(SizeOfDrinks size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drinks drinks = (Drinks) o;
        return Objects.equals(name, drinks.name) && Objects.equals(price, drinks.price) && size == drinks.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, size);
    }
}
