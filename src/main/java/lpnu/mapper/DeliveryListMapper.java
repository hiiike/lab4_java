package lpnu.mapper;
import lpnu.dto.DeliveryDTO;

import lpnu.entity.Delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeliveryListMapper {
    @Autowired
    OrderToOrderDTOMapper orderDTOMapper;

    public List<Delivery> toEntity(List<DeliveryDTO> deliveryDTOList){
        List<Delivery> deliveryList = new ArrayList<>();

        for (DeliveryDTO deliveryDTO: deliveryDTOList) {
            Delivery delivery = new Delivery();

            delivery.setId(deliveryDTO.getId());
            delivery.setTotalPrice(deliveryDTO.getTotalPrice());
            delivery.setOrder(orderDTOMapper.toEntity(deliveryDTO.getOrderDTO()));
            delivery.setAddress(deliveryDTO.getAddress());
            delivery.setKilometers(deliveryDTO.getKilometers());

            deliveryList.add(delivery);
        }
        return deliveryList;
    }

    public List<DeliveryDTO> toDTO(List<Delivery> deliveryList){
        List<DeliveryDTO> deliveryDTOList = new ArrayList<>();

        for (Delivery delivery: deliveryList) {
            DeliveryDTO deliveryDTO = new DeliveryDTO();

            deliveryDTO.setId(delivery.getId());
            deliveryDTO.setTotalPrice(delivery.getTotalPrice());
            deliveryDTO.setOrderDTO(orderDTOMapper.toDTO(delivery.getOrder()));
            deliveryDTO.setAddress(delivery.getAddress());
            deliveryDTO.setKilometers(delivery.getKilometers());

            deliveryDTOList.add(deliveryDTO);
        }
        return deliveryDTOList;
    }
}
