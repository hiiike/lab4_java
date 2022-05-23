package lpnu.resource;


import lpnu.dto.DrinksDTO;
import lpnu.service.DrinksService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DrinksResource {

    private DrinksService drinksService;

    public DrinksResource(final DrinksService drinksService) {
        this.drinksService = drinksService;
    }

    @GetMapping("/drinks")
    public List<DrinksDTO> getAllDrinks() {
        return drinksService.getAllDrinks();
    }

    @GetMapping("/drinks/{id}")
    public DrinksDTO getDrinksById(@PathVariable final long id) {
        return drinksService.getDrinksById(id);
    }


    @PostMapping("/drinks")
    public DrinksDTO saveDrinks(@RequestBody final DrinksDTO drinksDTO) {
        return drinksService.saveDrinks(drinksDTO);
    }


    @PutMapping(value = "/drinks", produces = "application/json", consumes = "application/json")
    public DrinksDTO updateDrinks(@RequestBody  final DrinksDTO drinksDTO) {
        return drinksService.updateDrinks(drinksDTO);
    }


    @DeleteMapping("/drinks/{id}")
    public ResponseEntity deleteDrinksById(@PathVariable final long id) {
        drinksService.deleteDrinksById(id);
        return ResponseEntity.ok().build();
    }
}
