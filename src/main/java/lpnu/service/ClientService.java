package lpnu.service;

import lpnu.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClient();
    ClientDTO getClientId(long id);
    ClientDTO updateClient(ClientDTO clientDTO);
    ClientDTO saveClient(ClientDTO clientDTO);
    void deleteClientId(long id);
}
