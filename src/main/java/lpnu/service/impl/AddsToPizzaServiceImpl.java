package lpnu.service.impl;

import lpnu.dto.AddsToPizzaDTO;
import lpnu.entity.AddsToPizza;
import lpnu.entity.Client;
import lpnu.mapper.AddsToPizzaToAddsToPizzaDTOMapper;
import lpnu.repository.AddsToPizzaRepository;
import lpnu.service.AddsToPizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddsToPizzaServiceImpl implements AddsToPizzaService {

    private final AddsToPizzaRepository addsRepository;
    private final AddsToPizzaToAddsToPizzaDTOMapper addsDTOMapper;

    public AddsToPizzaServiceImpl(AddsToPizzaRepository addsRepository, AddsToPizzaToAddsToPizzaDTOMapper addsDTOMapper) {
        this.addsRepository = addsRepository;
        this.addsDTOMapper = addsDTOMapper;
    }

    @Override
    public List<AddsToPizzaDTO> getAllAddsToPizza() {
        return addsRepository.getAllAddsToPizza().stream()
                .map(addsDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AddsToPizzaDTO getAddsToPizzaId(long id) {
        return addsDTOMapper.toDTO(addsRepository.getAddsToPizzaId(id));
    }

    @Override
    public AddsToPizzaDTO updateAddsToPizza(AddsToPizzaDTO addsDTO) {
        final AddsToPizza adds = addsDTOMapper.toEntity(addsDTO);
        addsRepository.updateAddsToPizza(adds);
        return addsDTO;
    }

    @Override
    public AddsToPizzaDTO saveAddsToPizza(AddsToPizzaDTO addsDTO) {
        final AddsToPizza adds = addsDTOMapper.toEntity(addsDTO);
        addsRepository.saveAddsToPizza(adds);
        return addsDTO;
    }

    @Override
    public void deleteAddsToPizzaId(long id) {
        addsRepository.deleteAddsToPizzaById(id);
    }
}
