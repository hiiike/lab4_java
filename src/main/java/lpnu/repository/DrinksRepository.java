package lpnu.repository;


import lpnu.entity.Drinks;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DrinksRepository {
    private List<Drinks> drinks = new ArrayList<>();
    private long id = 1;

    public List<Drinks> getAllDrinks() {
        return drinks;
    }

    public Drinks getDrinksId(long id) {
        return drinks.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Drink with id {" + id + "} not found"));
    }

    public Drinks saveDrinks(Drinks drink) {

        drink.setId(id++);
        drinks.add(drink);

        return drink;
    }

    public Drinks updateDrinks(Drinks drink) {
        Drinks savedDrinks = getDrinksId(drink.getId());

        savedDrinks.setName(drink.getName());
        savedDrinks.setPrice(drink.getPrice());
        savedDrinks.setSize(drink.getSize());


        return savedDrinks;
    }

    public void deleteDrinksId(long id) {
        drinks = drinks.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
