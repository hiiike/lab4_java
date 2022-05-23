package resource;

import lpnu.Application;

import lpnu.dto.AddsToPizzaDTO;
import lpnu.dto.PizzaDTO;
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
public class PizzaTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private PizzaService pizzaService;

    @Test
    public void savePizza_thenStatus200() throws Exception {
        AddsToPizzaDTO addsToPizzaDTO = new AddsToPizzaDTO(1L,"adds",10.);
        AddsToPizzaDTO addsToPizzaDTO1 = new AddsToPizzaDTO(1L,"adds1",111.);
        List<AddsToPizzaDTO> adds = new ArrayList<>();
        adds.add(addsToPizzaDTO);
        adds.add(addsToPizzaDTO1);
        final PizzaDTO pizzaDTO = new PizzaDTO(1L, "TestName",10.,adds);

        mvc.perform(post("/api/v1/pizza").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(pizzaDTO))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice", is(121.)));
    }
    @Test
    public void updatePizza_thenStatus200() throws Exception {
        final PizzaDTO pizzaDTO = new PizzaDTO(1L, "TestName",10.,new ArrayList<>());
        final PizzaDTO pizzaDTO1 = new PizzaDTO(1L, "TestName1",10.,new ArrayList<>());
        pizzaService.savePizza(pizzaDTO);

        mvc.perform(put("/api/v1/pizza").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(pizzaDTO1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName1")));
    }
    @Test
    public void getAllPizza_thenStatus200() throws Exception {
        final PizzaDTO pizzaDTO = new PizzaDTO(1L, "TestName",10.,new ArrayList<>());
        pizzaService.savePizza(pizzaDTO);

        mvc.perform(get("/api/v1/pizza").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("TestName")));
    }
    @Test
    public void getPizzaId_thenStatus200() throws Exception {
        final PizzaDTO pizzaDTO = new PizzaDTO(1L, "TestName",10.,new ArrayList<>());
        pizzaService.savePizza(pizzaDTO);

        mvc.perform(get("/api/v1/pizza/"+pizzaDTO.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }
    @Test
    public void deletePizzaId_thenStatus200() throws Exception {
        final PizzaDTO pizzaDTO = new PizzaDTO(1L, "TestName",10.,new ArrayList<>());
        pizzaService.savePizza(pizzaDTO);

        mvc.perform(delete("/api/v1/pizza/"+pizzaDTO.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                assertEquals(pizzaService.getAllPizza().size(),0);
    }
}
