package lpnu.mapper;

import lpnu.dto.DeliveryDTO;
import lpnu.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryToDeliveryDTOMapper {
    @Autowired
    OrderToOrderDTOMapper orderDTOMapper;

    public DeliveryToDeliveryDTOMapper(OrderToOrderDTOMapper orderDTOMapper) {
        this.orderDTOMapper = orderDTOMapper;
    }

    public Delivery toEntity(DeliveryDTO deliveryDTO){
        Delivery delivery = new Delivery();

        delivery.setId(deliveryDTO.getId());
        delivery.setTotalPrice(deliveryDTO.getTotalPrice());
        delivery.setOrder(orderDTOMapper.toEntity(deliveryDTO.getOrderDTO()));
        delivery.setAddress(deliveryDTO.getAddress());
        delivery.setKilometers(deliveryDTO.getKilometers());

        return delivery;
    }

    public DeliveryDTO toDTO(Delivery delivery){
        DeliveryDTO deliveryDTO = new DeliveryDTO();

        deliveryDTO.setId(delivery.getId());
        deliveryDTO.setTotalPrice(delivery.getTotalPrice());
        deliveryDTO.setOrderDTO(orderDTOMapper.toDTO(delivery.getOrder()));
        deliveryDTO.setAddress(delivery.getAddress());
        deliveryDTO.setKilometers(delivery.getKilometers());

        return deliveryDTO;
    }
}
