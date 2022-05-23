package lpnu.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDTO {
    private Long Id;
    private ClientDTO clientDTO;
    private List<PizzaDTO> pizzasDTO = new ArrayList<>();
    private List<DrinksDTO> drinksDTO = new ArrayList<>();
    private Double totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(Long Id, ClientDTO clientDTO, List<PizzaDTO> pizzasDTO, List<DrinksDTO> drinksDTO, Double totalPrice) {
        this.Id = Id;
        this.clientDTO = clientDTO;
        this.pizzasDTO = pizzasDTO;
        this.drinksDTO = drinksDTO;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public List<PizzaDTO> getPizzasDTO() {
        return pizzasDTO;
    }

    public void setPizzasDTO(List<PizzaDTO> pizzasDTO) {
        this.pizzasDTO = pizzasDTO;
    }

    public List<DrinksDTO> getDrinksDTO() {
        return drinksDTO;
    }

    public void setDrinksDTO(List<DrinksDTO> drinksDTO) {
        this.drinksDTO = drinksDTO;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(Id, orderDTO.Id) && Objects.equals(clientDTO, orderDTO.clientDTO) && Objects.equals(pizzasDTO, orderDTO.pizzasDTO) && Objects.equals(drinksDTO, orderDTO.drinksDTO) && Objects.equals(totalPrice, orderDTO.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, clientDTO, pizzasDTO, drinksDTO, totalPrice);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "Id=" + Id +
                ", clientDTO=" + clientDTO +
                ", pizzasDTO=" + pizzasDTO +
                ", drinksDTO=" + drinksDTO +
                ", totalPrice=" + totalPrice +
                '}';
    }
}