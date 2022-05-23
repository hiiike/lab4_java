package lpnu.repository;

import lpnu.entity.Order;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<>();
    private long id = 1;

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrdersId(long id) {
        return orders.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Order with id {" + id + "} not found"));
    }

    public Order saveOrder(Order order) {
        order.setId(id++);
        orders.add(order);

        return order;
    }

    public Order updateOrder(Order order){
        Order savedOrder = getOrdersId(order.getId());

        savedOrder.setClient(order.getClient());
        savedOrder.setDrinks(order.getDrinks());
        savedOrder.setPizzas(order.getPizzas());
        savedOrder.setTotalPrice(order.getTotalPrice());

        return savedOrder;
    }

    public void deleteOrderId(long id){
        orders = orders.stream()
                .filter(e->e.getId() != id)
                .collect(Collectors.toList());
    }
}