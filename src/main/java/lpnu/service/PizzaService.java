package lpnu.service;

import lpnu.dto.PizzaDTO;

import java.util.List;

public interface PizzaService {
    List<PizzaDTO> getAllPizza();
    PizzaDTO getPizzaById(long id);
    PizzaDTO savePizza(PizzaDTO pizzaDTO);
    PizzaDTO updatePizza(PizzaDTO orderDTO);
    void deletePizzaById(long id);

    Double pizzaAddsCost(PizzaDTO pizzaDTO);
}
