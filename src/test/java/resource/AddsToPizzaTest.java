package resource;

import lpnu.Application;
import lpnu.dto.AddsToPizzaDTO;
import lpnu.service.AddsToPizzaService;
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
public class AddsToPizzaTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private AddsToPizzaService toPizzaService;


    @Test
    public void saveAddsToPizza_thenStatus200() throws Exception {
        final AddsToPizzaDTO addsToPizzaDTO = new AddsToPizzaDTO(1L, "TestName", 1D);

        mvc.perform(post("/api/v1/adds").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(addsToPizzaDTO))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }

    @Test
    public void updateAddsToPizza_thenStatus200() throws Exception {
        final AddsToPizzaDTO addsToPizzaDTO = new AddsToPizzaDTO(1L, "TestName", 1D);
        final AddsToPizzaDTO addsToPizzaDTO1 = new AddsToPizzaDTO(1L, "TestName1", 1D);

        toPizzaService.saveAddsToPizza(addsToPizzaDTO);

        mvc.perform(put("/api/v1/adds").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(addsToPizzaDTO1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName1")));
    }

    @Test
    public void getAllAddsToPizza_thenStatus200() throws Exception {
        final AddsToPizzaDTO addsToPizzaDTO = new AddsToPizzaDTO(1L, "TestName", 1D);

        toPizzaService.saveAddsToPizza(addsToPizzaDTO);

        mvc.perform(get("/api/v1/adds").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("TestName")));
    }

    @Test
    public void getAddsToPizzaId_thenStatus200() throws Exception {
        final AddsToPizzaDTO addsToPizzaDTO = new AddsToPizzaDTO(1L, "TestName", 1D);

        toPizzaService.saveAddsToPizza(addsToPizzaDTO);

        mvc.perform(get("/api/v1/adds/" + addsToPizzaDTO.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }

    @Test
    public void deleteAddsToPizzaId_thenStatus200() throws Exception {
        final AddsToPizzaDTO addsToPizzaDTO = new AddsToPizzaDTO(1L, "TestName", 1D);

        toPizzaService.saveAddsToPizza(addsToPizzaDTO);

        mvc.perform(delete("/api/v1/adds/" + addsToPizzaDTO.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(toPizzaService.getAllAddsToPizza().size(), 0);
    }
}
