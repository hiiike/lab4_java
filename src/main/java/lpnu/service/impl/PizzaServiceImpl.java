package lpnu.service.impl;

import lpnu.dto.AddsToPizzaDTO;
import lpnu.dto.PizzaDTO;
import lpnu.entity.Drinks;
import lpnu.entity.Pizza;
import lpnu.mapper.PizzaToPizzaDTOMapper;
import lpnu.repository.PizzaRepository;
import lpnu.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaToPizzaDTOMapper pizzaDTOMapper;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, PizzaToPizzaDTOMapper pizzaDTOMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaDTOMapper = pizzaDTOMapper;
    }

    @Override
    public List<PizzaDTO> getAllPizza() {
        return pizzaRepository.getAllPizza().stream()
                .map(e -> pizzaDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public PizzaDTO getPizzaById(long id) {
        return pizzaDTOMapper.toDTO(pizzaRepository.getPizzaId(id));
    }

    @Override
    public PizzaDTO savePizza(PizzaDTO pizzaDTO) {
        pizzaDTO.setTotalPrice(pizzaAddsCost(pizzaDTO));
        final Pizza pizza = pizzaDTOMapper.toEntity(pizzaDTO);
        pizzaRepository.savePizza(pizza);

        return pizzaDTO;
    }

    @Override
    public PizzaDTO updatePizza(PizzaDTO pizzaDTO) {
        final Pizza pizza = pizzaDTOMapper.toEntity(pizzaDTO);
        pizzaRepository.updatePizza(pizza);
        return pizzaDTO;
    }

    @Override
    public void deletePizzaById(long id) {
        pizzaRepository.deletePizzaId(id);

    }

    @Override
    public Double pizzaAddsCost(PizzaDTO pizzaDTO) {
        return pizzaDTO.getAddsDTO().stream().mapToDouble(AddsToPizzaDTO::getPrice).sum();
    }


}
