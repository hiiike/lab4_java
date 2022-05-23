package lpnu.resource;


import lpnu.dto.DeliveryDTO;
import lpnu.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DeliveryResource {
    private DeliveryService deliveryService;

    public DeliveryResource(final DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/delivery")
    public List<DeliveryDTO> getAllDelivery() {
        return deliveryService.getAllDelivery();
    }

    @GetMapping("/delivery/{id}")
    public DeliveryDTO getDeliveryById(@PathVariable final long id) {
        return deliveryService.getDeliveryId(id);
    }


    @PostMapping(value = "/delivery", produces = "application/json", consumes = "application/json")
    public DeliveryDTO saveDelivery(@RequestBody final DeliveryDTO deliveryDTO) {
        return deliveryService.saveDelivery(deliveryDTO);
    }


    @PutMapping(value = "/delivery", produces = "application/json", consumes = "application/json")
    public DeliveryDTO updateDelivery(@RequestBody  final DeliveryDTO deliveryDTO) {
        return deliveryService.updateDelivery(deliveryDTO);
    }


    @DeleteMapping("/delivery/{id}")
    public ResponseEntity deleteDeliveryById(@PathVariable final long id) {
        deliveryService.deleteDeliveryId(id);
        return ResponseEntity.ok().build();
    }
}
