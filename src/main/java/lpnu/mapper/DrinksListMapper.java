package lpnu.mapper;
import lpnu.dto.DrinksDTO;
import lpnu.entity.Drinks;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrinksListMapper {
    public List<Drinks> toEntity(List<DrinksDTO> drinksDTOList){
        List<Drinks> drinksList = new ArrayList<>();

        for (DrinksDTO drinksDTO: drinksDTOList) {
            Drinks drinks = new Drinks();

            drinks.setId(drinksDTO.getId());
            drinks.setName(drinksDTO.getName());
            drinks.setPrice(drinksDTO.getPrice());
            drinks.setSize(drinksDTO.getSize());

            drinksList.add(drinks);
        }
        return drinksList;
    }

    public List<DrinksDTO> toDTO(List<Drinks> drinksList){
        List<DrinksDTO> drinksDTOList = new ArrayList<>();

        for (Drinks drinks: drinksList) {
            DrinksDTO drinksDTO = new DrinksDTO();

            drinksDTO.setId(drinks.getId());
            drinksDTO.setName(drinks.getName());
            drinksDTO.setPrice(drinks.getPrice());
            drinksDTO.setSize(drinks.getSize());

            drinksDTOList.add(drinksDTO);
        }
        return drinksDTOList;
    }
}
