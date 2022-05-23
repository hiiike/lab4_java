package lpnu.resource;

import lpnu.dto.AddsToPizzaDTO;
import lpnu.service.AddsToPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddsToPizzaResource {

    @Autowired
    private final AddsToPizzaService addsToPizzaService;

    public AddsToPizzaResource(AddsToPizzaService addsToPizzaService) {
        this.addsToPizzaService = addsToPizzaService;
    }

    @GetMapping("/adds")
    public List<AddsToPizzaDTO> getAllAddsToPizza(){
        return addsToPizzaService.getAllAddsToPizza();
    }

    @GetMapping("/adds/{id}")
    public AddsToPizzaDTO getAddsToPizzaId(@PathVariable @Validated long id){
        return addsToPizzaService.getAddsToPizzaId(id);
    }

    @PostMapping("/adds")
    public AddsToPizzaDTO saveAddsToPizza(@RequestBody @Validated AddsToPizzaDTO addsToPizzaDTO){
        return addsToPizzaService.saveAddsToPizza(addsToPizzaDTO);
    }

    @PutMapping("/adds")
    public AddsToPizzaDTO updateAddsToPizza(@RequestBody @Validated AddsToPizzaDTO addsToPizzaDTO){
        return addsToPizzaService.updateAddsToPizza(addsToPizzaDTO);
    }

    @DeleteMapping("/adds/{id}")
    public void deleteAddsToPizzaId(@PathVariable @Validated long id){
        addsToPizzaService.deleteAddsToPizzaId(id);
    }
}
