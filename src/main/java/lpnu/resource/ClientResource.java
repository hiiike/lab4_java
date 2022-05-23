package lpnu.resource;


import lpnu.dto.ClientDTO;
import lpnu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientDTO> getAllClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientId(@PathVariable @Validated long id){
        return clientService.getClientId(id);
    }


    @PostMapping("/clients")
    public ClientDTO saveClient(@RequestBody @Validated ClientDTO clientDTO){
        return clientService.saveClient(clientDTO);
    }

    @PutMapping("/clients")
    public ClientDTO updateClient(@RequestBody @Validated ClientDTO clientDTO){
        return clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClientId(@PathVariable @Validated long id){
        clientService.deleteClientId(id);
    }
}
