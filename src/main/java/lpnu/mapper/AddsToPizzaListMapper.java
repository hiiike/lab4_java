package lpnu.mapper;
import lpnu.dto.AddsToPizzaDTO;
import lpnu.entity.AddsToPizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddsToPizzaListMapper {

    public List<AddsToPizza> toEntity(List<AddsToPizzaDTO> addsDTOList){
        List<AddsToPizza> addsList = new ArrayList<>();

        for (AddsToPizzaDTO addsDTO: addsDTOList) {
            AddsToPizza adds = new AddsToPizza();

            adds.setId(addsDTO.getId());
            adds.setPrice(addsDTO.getPrice());
            adds.setName(addsDTO.getName());

            addsList.add(adds);
        }
        return addsList;
    }

    public List<AddsToPizzaDTO> toDTO(List<AddsToPizza> addsList){
        List<AddsToPizzaDTO> addsDTOList = new ArrayList<>();

        for (AddsToPizza adds: addsList) {
            AddsToPizzaDTO addsDTO = new AddsToPizzaDTO();

            addsDTO.setId(adds.getId());
            addsDTO.setPrice(adds.getPrice());
            addsDTO.setName(adds.getName());

            addsDTOList.add(addsDTO);
        }
        return addsDTOList;
    }
}
