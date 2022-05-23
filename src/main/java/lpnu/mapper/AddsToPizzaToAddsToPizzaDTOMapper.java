package lpnu.mapper;

import lpnu.dto.AddsToPizzaDTO;
import lpnu.entity.AddsToPizza;
import org.springframework.stereotype.Component;

@Component
public class AddsToPizzaToAddsToPizzaDTOMapper {

    public AddsToPizza toEntity(AddsToPizzaDTO addsDTO){
        AddsToPizza adds = new AddsToPizza();

       adds.setId(addsDTO.getId());
       adds.setPrice(addsDTO.getPrice());
       adds.setName(addsDTO.getName());

        return adds;
    }

    public AddsToPizzaDTO toDTO(AddsToPizza adds){
        AddsToPizzaDTO addsDTO = new AddsToPizzaDTO();

        addsDTO.setId(adds.getId());
        addsDTO.setPrice(adds.getPrice());
        addsDTO.setName(adds.getName());

        return addsDTO;
    }
}
