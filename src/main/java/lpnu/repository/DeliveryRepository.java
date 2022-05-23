package lpnu.repository;


import lpnu.entity.Delivery;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository

public class DeliveryRepository {
    private List<Delivery> deliveries = new ArrayList<>();
    private long id = 1;

    public List<Delivery> getAllDelivery() {
        return deliveries;
    }

    public Delivery getDeliveryId(long id) {
        return deliveries.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Delivery with id {" + id + "} not found"));
    }

    public Delivery saveDelivery(Delivery drink) {

        drink.setId(id++);
        deliveries.add(drink);

        return drink;
    }

    public Delivery updateDelivery(Delivery delivery) {
        Delivery savedDelivery = getDeliveryId(delivery.getId());

        savedDelivery.setAddress(delivery.getAddress());
        savedDelivery.setKilometers(delivery.getKilometers());
        savedDelivery.setOrder(delivery.getOrder());
        savedDelivery.setTotalPrice(delivery.getTotalPrice());

        return savedDelivery;
    }

    public void deleteDeliveryId(long id) {
        deliveries = deliveries.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
