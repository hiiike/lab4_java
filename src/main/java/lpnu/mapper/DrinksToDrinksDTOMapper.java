package lpnu.mapper;

import lpnu.dto.DrinksDTO;
import lpnu.entity.Drinks;
import org.springframework.stereotype.Component;

@Component
public class DrinksToDrinksDTOMapper {
    public Drinks toEntity(DrinksDTO drinksDTO){
        Drinks drinks = new Drinks();

        drinks.setId(drinksDTO.getId());
        drinks.setName(drinksDTO.getName());
        drinks.setPrice(drinksDTO.getPrice());
        drinks.setSize(drinksDTO.getSize());

        return drinks;
    }

    public DrinksDTO toDTO(Drinks drinks){
        DrinksDTO drinksDTO = new DrinksDTO();

        drinksDTO.setId(drinks.getId());
        drinksDTO.setName(drinks.getName());
        drinksDTO.setPrice(drinks.getPrice());
        drinksDTO.setSize(drinks.getSize());

        return drinksDTO;
    }
}
