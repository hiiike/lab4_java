package lpnu.mapper;

import lpnu.dto.PizzaDTO;
import lpnu.entity.Pizza;
import org.springframework.stereotype.Component;

@Component
public class PizzaToPizzaDTOMapper {

    AddsToPizzaListMapper addsToPizzaListMapper;

    public PizzaToPizzaDTOMapper(AddsToPizzaListMapper addsToPizzaListMapper) {
        this.addsToPizzaListMapper = addsToPizzaListMapper;
    }

    public Pizza toEntity(PizzaDTO pizzaDTO){
        Pizza pizza = new Pizza();

     pizza.setId(pizzaDTO.getId());
     pizza.setName(pizzaDTO.getName());
     pizza.setAdds(addsToPizzaListMapper.toEntity(pizzaDTO.getAddsDTO()));
     pizza.setTotalPrice(pizzaDTO.getTotalPrice());

        return pizza;
    }

    public PizzaDTO toDTO(Pizza pizza){
        PizzaDTO pizzaDTO = new PizzaDTO();

        pizzaDTO.setId(pizza.getId());
        pizzaDTO.setName(pizza.getName());
        pizzaDTO.setAddsDTO(addsToPizzaListMapper.toDTO(pizza.getAdds()));
        pizzaDTO.setTotalPrice(pizza.getTotalPrice());

        return pizzaDTO;
    }
}
