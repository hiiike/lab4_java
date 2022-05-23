package lpnu.entity;

import java.util.Objects;

public class Delivery {

    private Long id;
    private String address;
    private Order order;
    private Double kilometers;
    private Double totalPrice;

    public Delivery() {
    }

    public Delivery(Long id, String address, Order order, Double kilometers, Double totalPrice) {
        this.id = id;
        this.address = address;
        this.order = order;
        this.kilometers = kilometers;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
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
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id) && Objects.equals(address, delivery.address) && Objects.equals(order, delivery.order) && Objects.equals(kilometers, delivery.kilometers) && Objects.equals(totalPrice, delivery.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, order, kilometers, totalPrice);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", order=" + order +
                ", kilometers=" + kilometers +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
