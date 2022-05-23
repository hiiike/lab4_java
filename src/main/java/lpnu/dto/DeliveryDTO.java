package lpnu.dto;

import java.util.Objects;

public class DeliveryDTO {
    private Long id;
    private String address;
    private OrderDTO orderDTO;
    private Double kilometers;
    private Double totalPrice;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Long id, String address, OrderDTO orderDTO, Double kilometers, Double totalPrice) {
        this.id = id;
        this.address = address;
        this.orderDTO = orderDTO;
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

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
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
        DeliveryDTO that = (DeliveryDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(orderDTO, that.orderDTO) && Objects.equals(kilometers, that.kilometers) && Objects.equals(totalPrice, that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, orderDTO, kilometers, totalPrice);
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", orderDTO=" + orderDTO +
                ", kilometers=" + kilometers +
                ", totalPrice=" + totalPrice +
                '}';
    }
}