package lpnu.service;

import lpnu.dto.DrinksDTO;

import java.util.List;

public interface DrinksService {
    List<DrinksDTO> getAllDrinks();
    DrinksDTO getDrinksById(long id);
    DrinksDTO saveDrinks(DrinksDTO drinksDTO);
    DrinksDTO updateDrinks(DrinksDTO drinksDTO);
    void deleteDrinksById(long id);

}
