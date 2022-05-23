package lpnu.dto;

import lpnu.entity.AddsToPizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PizzaDTO {

    private Long id;
    private String name;
    private Double totalPrice;
    private List<AddsToPizzaDTO> addsDTO = new ArrayList<>();

    public PizzaDTO() {
    }

    public PizzaDTO(Long id, String name, Double totalPrice, List<AddsToPizzaDTO> addsDTO) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.addsDTO = addsDTO;
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

    public List<AddsToPizzaDTO> getAddsDTO() {
        return addsDTO;
    }

    public void setAddsDTO(List<AddsToPizzaDTO> addsDTO) {
        this.addsDTO = addsDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaDTO pizzaDTO = (PizzaDTO) o;
        return Objects.equals(id, pizzaDTO.id) && Objects.equals(name, pizzaDTO.name) && Objects.equals(totalPrice, pizzaDTO.totalPrice) && Objects.equals(addsDTO, pizzaDTO.addsDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, totalPrice, addsDTO);
    }

    @Override
    public String toString() {
        return "PizzaDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", addsDTO=" + addsDTO +
                '}';
    }
}
