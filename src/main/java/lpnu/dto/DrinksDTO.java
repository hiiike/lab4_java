package lpnu.dto;

import lpnu.entity.enumeration.SizeOfDrinks;

import java.util.Objects;


public class DrinksDTO {
    private Long id;
    private String name;
    private Double price;
    private SizeOfDrinks size;

    public DrinksDTO() {
    }

    public DrinksDTO(Long id, String name, Double price, SizeOfDrinks size) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinksDTO drinksDTO = (DrinksDTO) o;
        return Objects.equals(id, drinksDTO.id) && Objects.equals(name, drinksDTO.name) && Objects.equals(price, drinksDTO.price) && size == drinksDTO.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, size);
    }

    @Override
    public String toString() {
        return "DrinksDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}
