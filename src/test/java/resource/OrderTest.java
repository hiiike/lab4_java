package resource;
import lpnu.Application;


import lpnu.dto.*;
import lpnu.entity.enumeration.SizeOfDrinks;
import lpnu.service.OrderService;
import lpnu.service.PizzaService;
import lpnu.util.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class OrderTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderService orderService;

    @Test
    public void saveOrder_thenStatus200() throws Exception {
        List<AddsToPizzaDTO> adds = new ArrayList<>();
        adds.add(new AddsToPizzaDTO(1L,"adds",10.));
        List<PizzaDTO> pizzaDTOList = new ArrayList<>();
        pizzaDTOList.add(new PizzaDTO(1L, "TestName",10.,adds));
        List<DrinksDTO> drinksDTOList = new ArrayList<>();
        drinksDTOList.add(new DrinksDTO(1L, "TestName",10., SizeOfDrinks.BIG));

        final OrderDTO orderDTO = new OrderDTO(1L,new ClientDTO(),pizzaDTOList,drinksDTOList,10.);

        mvc.perform(post("/api/v1/orders").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(orderDTO))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice", is(20.)));
    }
}
