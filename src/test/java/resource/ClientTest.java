package resource;

import lpnu.Application;
import lpnu.dto.ClientDTO;
import lpnu.service.ClientService;
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
public class ClientTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ClientService clientService;


    @Test
    public void saveClient_thenStatus200() throws Exception {
        final ClientDTO client = new ClientDTO(1L, "TestName", "TestSurname","qe");

        mvc.perform(post("/api/v1/clients").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(client))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }

    @Test
    public void updateClient_thenStatus200() throws Exception {
        final ClientDTO client = new ClientDTO(1L, "TestName", "TestSurname","qe");
        final ClientDTO client1 = new ClientDTO(1L, "TestName1", "TestSurname1","qe");

        clientService.saveClient(client);
        mvc.perform(put("/api/v1/clients").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(client1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName1")));
    }

    @Test
    public void getAllClient_thenStatus200() throws Exception {
        final ClientDTO client = new ClientDTO(1L, "TestName", "TestSurname","qe");

        clientService.saveClient(client);
        mvc.perform(get("/api/v1/clients").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("TestName")));
    }
    @Test
    public void getClientId_thenStatus200() throws Exception {
        final ClientDTO client = new ClientDTO(1L, "TestName", "TestSurname","qe");

        clientService.saveClient(client);
        mvc.perform(get("/api/v1/clients/"+client.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }
    @Test
    public void deleteClientId_thenStatus200() throws Exception {
        final ClientDTO client = new ClientDTO(1L, "TestName", "TestSurname","qe");

        clientService.saveClient(client);
        mvc.perform(delete("/api/v1/clients/"+client.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(clientService.getAllClient().size(),0);
    }
}
