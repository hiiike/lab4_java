package lpnu.service;

import lpnu.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(long id);
    OrderDTO saveOrder(OrderDTO orderDTO);
    OrderDTO updateOrder(OrderDTO orderDTO);
    void deleteOrderById(long id);

    Double getTotalPrice(OrderDTO orderDTO);
}
