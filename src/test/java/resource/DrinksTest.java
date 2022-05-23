package resource;

import lpnu.Application;
import lpnu.dto.DrinksDTO;
import lpnu.entity.enumeration.SizeOfDrinks;
import lpnu.service.DrinksService;
import lpnu.util.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class DrinksTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private DrinksService drinksService;


    @Test
    public void saveDrinks_thenStatus200() throws Exception {
        final DrinksDTO drinksDTO = new DrinksDTO(1L, "TestName",10., SizeOfDrinks.BIG);

        mvc.perform(post("/api/v1/drinks").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(drinksDTO))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }
    @Test
    public void updateDrinks_thenStatus200() throws Exception {
        final DrinksDTO drinksDTO = new DrinksDTO(1L, "TestName",10., SizeOfDrinks.BIG);
        final DrinksDTO drinksDTO1 = new DrinksDTO(1L, "TestName1",10., SizeOfDrinks.BIG);

        drinksService.saveDrinks(drinksDTO);

        mvc.perform(put("/api/v1/drinks").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(drinksDTO1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName1")));
    }
    @Test
    public void getAllDrinks_thenStatus200() throws Exception {
        final DrinksDTO drinksDTO = new DrinksDTO(1L, "TestName",10., SizeOfDrinks.BIG);

        drinksService.saveDrinks(drinksDTO);

        mvc.perform(get("/api/v1/drinks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("TestName")));
    }

    @Test
    public void getDrinksId_thenStatus200() throws Exception {
        final DrinksDTO drinksDTO = new DrinksDTO(1L, "TestName",10., SizeOfDrinks.BIG);

        drinksService.saveDrinks(drinksDTO);

        mvc.perform(get("/api/v1/drinks/"+drinksDTO.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }
    @Test
    public void deleteDrinksId_thenStatus200() throws Exception {
        final DrinksDTO drinksDTO = new DrinksDTO(1L, "TestName",10., SizeOfDrinks.BIG);

        drinksService.saveDrinks(drinksDTO);

        mvc.perform(delete("/api/v1/drinks/"+drinksDTO.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(drinksService.getAllDrinks().size(),0);
    }
}
