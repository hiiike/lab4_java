package lpnu.mapper;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderDTOMapper {

    ClientToClientDTOMapper clientDTOMapper;
    PizzaListMapper pizzaListMapper;
    DrinksListMapper drinksListMapper;

    public OrderToOrderDTOMapper(ClientToClientDTOMapper clientDTOMapper, PizzaListMapper pizzaListMapper, DrinksListMapper drinksListMapper) {
        this.clientDTOMapper = clientDTOMapper;
        this.pizzaListMapper = pizzaListMapper;
        this.drinksListMapper = drinksListMapper;

    }

    public Order toEntity(OrderDTO orderDTO){
        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setClient(clientDTOMapper.toEntity(orderDTO.getClientDTO()));
        order.setPizzas(pizzaListMapper.toEntity(orderDTO.getPizzasDTO()));
        order.setDrinks(drinksListMapper.toEntity(orderDTO.getDrinksDTO()));
        order.setTotalPrice(orderDTO.getTotalPrice());

        return order;
    }

    public OrderDTO toDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setClientDTO(clientDTOMapper.toDTO(order.getClient()));
        orderDTO.setPizzasDTO(pizzaListMapper.toDTO(order.getPizzas()));
        orderDTO.setDrinksDTO(drinksListMapper.toDTO(order.getDrinks()));
        order.setTotalPrice(orderDTO.getTotalPrice());

        return orderDTO;
    }
}
