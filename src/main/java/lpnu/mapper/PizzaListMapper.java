package lpnu.mapper;
import lpnu.dto.PizzaDTO;
import lpnu.entity.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaListMapper {
    AddsToPizzaListMapper addsToPizzaListMapper;

    public PizzaListMapper(AddsToPizzaListMapper addsToPizzaListMapper) {
        this.addsToPizzaListMapper = addsToPizzaListMapper;
    }

    public List<Pizza> toEntity(List<PizzaDTO> pizzaDTOList){
        List<Pizza> pizzaList = new ArrayList<>();

        for (PizzaDTO pizzaDTO: pizzaDTOList) {
            Pizza pizza = new Pizza();

            pizza.setId(pizzaDTO.getId());
            pizza.setName(pizzaDTO.getName());
            pizza.setAdds(addsToPizzaListMapper.toEntity(pizzaDTO.getAddsDTO()));
            pizza.setTotalPrice(pizzaDTO.getTotalPrice());

            pizzaList.add(pizza);
        }
        return pizzaList;
    }

    public List<PizzaDTO> toDTO(List<Pizza> pizzaList){
        List<PizzaDTO> pizzaDTOList = new ArrayList<>();

        for (Pizza pizza: pizzaList) {
            PizzaDTO pizzaDTO = new PizzaDTO();

            pizzaDTO.setId(pizza.getId());
            pizzaDTO.setName(pizza.getName());
            pizzaDTO.setAddsDTO(addsToPizzaListMapper.toDTO(pizza.getAdds()));
            pizzaDTO.setTotalPrice(pizza.getTotalPrice());

            pizzaDTOList.add(pizzaDTO);
        }
        return pizzaDTOList;
    }
}
