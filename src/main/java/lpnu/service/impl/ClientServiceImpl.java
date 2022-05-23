package lpnu.service.impl;

import lpnu.dto.ClientDTO;
import lpnu.entity.Client;
import lpnu.mapper.ClientToClientDTOMapper;
import lpnu.repository.ClientRepository;
import lpnu.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientToClientDTOMapper clientDTOMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientToClientDTOMapper clientDTOMapper) {
        this.clientRepository = clientRepository;
        this.clientDTOMapper = clientDTOMapper;
    }

    @Override
    public List<ClientDTO> getAllClient() {
        return clientRepository.getAllClients().stream()
                .map(clientDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientId(long id) {
        return clientDTOMapper.toDTO(clientRepository.getClientById(id));
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
       final Client client = clientDTOMapper.toEntity(clientDTO);
        clientRepository.updateClient(client);
        return clientDTO;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        final Client client = clientDTOMapper.toEntity(clientDTO);
        clientRepository.saveClient(client);
        return clientDTO;
    }

    @Override
    public void deleteClientId(long id) {
        clientRepository.deleteClientById(id);
    }
}
