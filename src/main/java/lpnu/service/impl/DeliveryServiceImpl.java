package lpnu.service.impl;

import lpnu.dto.*;
import lpnu.entity.Delivery;

import lpnu.mapper.DeliveryToDeliveryDTOMapper;
import lpnu.repository.DeliveryRepository;
import lpnu.service.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryToDeliveryDTOMapper deliveryDTOMapper;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryToDeliveryDTOMapper deliveryDTOMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryDTOMapper = deliveryDTOMapper;
    }

    @Override
    public List<DeliveryDTO> getAllDelivery() {
        return deliveryRepository.getAllDelivery().stream()
                .map(deliveryDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDTO getDeliveryId(long id) {
        return deliveryDTOMapper.toDTO(deliveryRepository.getDeliveryId(id));
    }

    @Override
    public DeliveryDTO updateDelivery(DeliveryDTO deliveryDTO) {
        final Delivery delivery = deliveryDTOMapper.toEntity(deliveryDTO);
        deliveryRepository.updateDelivery(delivery);
        return deliveryDTO;
    }

    @Override
    public DeliveryDTO saveDelivery(DeliveryDTO deliveryDTO) {
        final Delivery delivery = deliveryDTOMapper.toEntity(deliveryDTO);
        deliveryRepository.saveDelivery(delivery);
        return deliveryDTO;
    }

    @Override
    public void deleteDeliveryId(long id) {
        deliveryRepository.deleteDeliveryId(id);
    }

    @Override
    public Double getDeliveryCost(Double km) {
        Double pricePerKilometer = 15.5;
        Double deliveryCost = pricePerKilometer*km;
        if(deliveryCost>=500)
            return 0D;
        else
            return deliveryCost;
    }


//    @Override
//    public Double  getTotalPrice(PizzaDTO pizzaDTO, DrinksDTO drinksDTO, AddsToPizzaDTO addsToPizzaDTO) {
//        Double totalPrice = pizzaDTO.getTotalPrice() + drinksDTO.getPrice() + addsToPizzaDTO.getPrice()+getDeliveryCost();
//
//        return totalPrice;
//    }

    @Override
    public Double getTotalPrice(OrderDTO orderDTO,Double km){

        return orderDTO.getTotalPrice() + getDeliveryCost(km);
    }


}
