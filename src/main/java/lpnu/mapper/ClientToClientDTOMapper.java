package lpnu.mapper;
import lpnu.dto.ClientDTO;
import lpnu.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientToClientDTOMapper {
    public Client toEntity(ClientDTO clientDTO){
        Client client = new Client();

        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setSurname(clientDTO.getSurname());
        client.setPhoneNumber(clientDTO.getPhoneNumber());

        return client;
    }

    public ClientDTO toDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setSurname(client.getSurname());
        clientDTO.setPhoneNumber(client.getPhoneNumber());

        return clientDTO;
    }
}
