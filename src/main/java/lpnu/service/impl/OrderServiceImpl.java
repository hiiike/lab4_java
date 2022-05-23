package lpnu.service.impl;

import lpnu.dto.DrinksDTO;
import lpnu.dto.OrderDTO;
import lpnu.dto.PizzaDTO;
import lpnu.entity.Order;
import lpnu.mapper.OrderToOrderDTOMapper;
import lpnu.repository.OrderRepository;
import lpnu.service.OrderService;
import lpnu.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderToOrderDTOMapper orderMapper;
    private final PizzaService pizzaService;


    public OrderServiceImpl(final OrderRepository orderRepository, final OrderToOrderDTOMapper orderMapper, PizzaService pizzaService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.pizzaService = pizzaService;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(final long id) {
        return orderMapper.toDTO(orderRepository.getOrdersId(id));
    }

    @Override
    public OrderDTO saveOrder(final OrderDTO orderDTO) {

        for (PizzaDTO pizzaDTO:orderDTO.getPizzasDTO())
            pizzaService.savePizza(pizzaDTO);

        orderDTO.setTotalPrice(getTotalPrice(orderDTO));
        final Order order = orderMapper.toEntity(orderDTO);
        orderRepository.saveOrder(order);

        return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(final OrderDTO orderDTO) {

        final Order order = orderMapper.toEntity(orderDTO);

        return orderMapper.toDTO(orderRepository.updateOrder(order));
    }

    @Override
    public void deleteOrderById(final long id) {
        orderRepository.deleteOrderId(id);
    }

    @Override
    public Double getTotalPrice(OrderDTO orderDTO) {
        double totalPrice = 0.;

        for (PizzaDTO pizzaDTO : orderDTO.getPizzasDTO()) {
            if(pizzaService.getAllPizza().stream().anyMatch(e->e.equals(pizzaDTO)))
                totalPrice += pizzaDTO.getTotalPrice();

        }
        for (DrinksDTO drinksDTO : orderDTO.getDrinksDTO()) {
            totalPrice += drinksDTO.getPrice();
        }


        return totalPrice;
    }
}
