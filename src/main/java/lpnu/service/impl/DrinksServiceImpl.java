package lpnu.service.impl;


import lpnu.dto.DrinksDTO;
import lpnu.entity.Delivery;
import lpnu.entity.Drinks;
import lpnu.mapper.DrinksToDrinksDTOMapper;
import lpnu.repository.DrinksRepository;
import lpnu.service.DrinksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinksServiceImpl implements DrinksService {

    private final DrinksRepository drinksRepository;
    private final DrinksToDrinksDTOMapper drinksDTOMapper;

    public DrinksServiceImpl(DrinksRepository drinksRepository, DrinksToDrinksDTOMapper drinksDTOMapper) {
        this.drinksRepository = drinksRepository;
        this.drinksDTOMapper = drinksDTOMapper;
    }

    @Override
    public List<DrinksDTO> getAllDrinks() {
        return drinksRepository.getAllDrinks().stream()
                .map(drinksDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DrinksDTO getDrinksById(long id) {
        return drinksDTOMapper.toDTO(drinksRepository.getDrinksId(id));
    }

    @Override
    public DrinksDTO saveDrinks(DrinksDTO drinksDTO) {
        final Drinks drinks = drinksDTOMapper.toEntity(drinksDTO);
        drinksRepository.saveDrinks(drinks);
        return drinksDTO;
    }

    @Override
    public DrinksDTO updateDrinks(DrinksDTO drinksDTO) {
        final Drinks drinks = drinksDTOMapper.toEntity(drinksDTO);
        drinksRepository.updateDrinks(drinks);
        return drinksDTO;
    }

    @Override
    public void deleteDrinksById(long id) {
        drinksRepository.deleteDrinksId(id);
    }
}
