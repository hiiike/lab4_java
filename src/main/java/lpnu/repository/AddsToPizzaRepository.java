package lpnu.repository;

import lpnu.entity.AddsToPizza;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class AddsToPizzaRepository {

    private List<AddsToPizza> adds = new ArrayList<>();
    private long id = 1;

    public List<AddsToPizza> getAllAddsToPizza() {
        return adds;
    }

    public AddsToPizza getAddsToPizzaId(long id) {
        return adds.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "AddsToPizza with id {" + id + "} not found"));
    }

    public AddsToPizza saveAddsToPizza(AddsToPizza add) {
        add.setId(id++);
        adds.add(add);

        return add;
    }

    public AddsToPizza updateAddsToPizza(AddsToPizza add){
        AddsToPizza savedAddsToPizza = getAddsToPizzaId(add.getId());

        savedAddsToPizza.setName(add.getName());
        savedAddsToPizza.setPrice(add.getPrice());

        return savedAddsToPizza;
    }

    public void deleteAddsToPizzaById(final long id) {
        adds = adds.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
