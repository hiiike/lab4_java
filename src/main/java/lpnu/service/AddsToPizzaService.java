package lpnu.service;

import lpnu.dto.AddsToPizzaDTO;

import java.util.List;

public interface AddsToPizzaService {
    List<AddsToPizzaDTO> getAllAddsToPizza();
    AddsToPizzaDTO getAddsToPizzaId(long id);
    AddsToPizzaDTO updateAddsToPizza(AddsToPizzaDTO addsDTO);
    AddsToPizzaDTO saveAddsToPizza(AddsToPizzaDTO addsDTO);
    void deleteAddsToPizzaId(long id);

}
