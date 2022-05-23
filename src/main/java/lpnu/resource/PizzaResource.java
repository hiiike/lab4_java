package lpnu.resource;

import lpnu.dto.PizzaDTO;
import lpnu.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PizzaResource {
    private PizzaService pizzaService;

    public PizzaResource(final PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizza")
    public List<PizzaDTO> getAllPizza() {
        return pizzaService.getAllPizza();
    }

    @GetMapping("/pizza/{id}")
    public PizzaDTO getPizzaById(@PathVariable final long id) {
        return pizzaService.getPizzaById(id);
    }


    @PostMapping("/pizza")
    public PizzaDTO savePizza(@RequestBody final PizzaDTO pizzaDTO) {
        return pizzaService.savePizza(pizzaDTO);
    }


    @PutMapping("/pizza")
    public PizzaDTO updatePizza(@RequestBody final PizzaDTO pizzaDTO) {
        return pizzaService.updatePizza(pizzaDTO);
    }


    @DeleteMapping("/pizza/{id}")
    public ResponseEntity deletePizzaById(@PathVariable final long id) {
        pizzaService.deletePizzaById(id);
        return ResponseEntity.ok().build();
    }
}
