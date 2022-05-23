package lpnu.repository;

import lpnu.entity.Pizza;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class PizzaRepository {
    private List<Pizza> pizzas = new ArrayList<>();
    private long id = 1;

    public List<Pizza> getAllPizza() {
        return pizzas;
    }

    public Pizza getPizzaId(long id) {
        return pizzas.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Pizza with id {" + id + "} not found"));
    }

    public Pizza savePizza(Pizza pizza) {

        pizza.setId(id++);
        pizzas.add(pizza);

        return pizza;
    }

    public Pizza updatePizza(Pizza pizza) {
        Pizza savedPizza = getPizzaId(pizza.getId());

        savedPizza.setName(pizza.getName());
        savedPizza.setAdds(pizza.getAdds());
        savedPizza.setTotalPrice(pizza.getTotalPrice());


        return savedPizza;
    }

    public void deletePizzaId(long id) {
        pizzas = pizzas.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
