package lpnu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long id;
    private Client client;
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Drinks> drinks = new ArrayList<>();
    private Double totalPrice;

    public Order() {
    }

    public Order(Long id, Client client, List<Pizza> pizzas, List<Drinks> drinks, Double totalPrice) {
        this.id = id;
        this.client = client;
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drinks> drinks) {
        this.drinks = drinks;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", pizzas=" + pizzas +
                ", drinks=" + drinks +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(client, order.client) && Objects.equals(pizzas, order.pizzas) && Objects.equals(drinks, order.drinks) && Objects.equals(totalPrice, order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, pizzas, drinks, totalPrice);
    }
}
