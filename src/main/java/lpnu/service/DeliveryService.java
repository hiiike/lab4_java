package lpnu.service;

import lpnu.dto.DeliveryDTO;
import lpnu.dto.OrderDTO;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDTO> getAllDelivery();
    DeliveryDTO getDeliveryId(long id);
    DeliveryDTO updateDelivery(DeliveryDTO deliveryDTO);
    DeliveryDTO saveDelivery(DeliveryDTO deliveryDTO);
    void deleteDeliveryId(long id);

    Double getDeliveryCost(Double km);
//    Double getTotalPrice(PizzaDTO pizzaDTO, DrinksDTO drinksDTO, AddsToPizzaDTO addsToPizzaDTO);
    Double getTotalPrice(OrderDTO orderDTO,Double km);
}
