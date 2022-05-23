package lpnu.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import lpnu.entity.Client;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClientRepository {
    private List<Client> clients = new ArrayList<>();

    private long id = 1;

    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    public Client getClientById(final long id) {
        return clients.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "client with id {" + id + "} not found"));
    }

    public Client saveClient(final Client client) {
        client.setId(id);

        ++id;

        clients.add(client);
        return client;
    }

    public Client updateClient(final Client client) {

        final Client savedClient = getClientById(client.getId());

        savedClient.setName(client.getName());
        savedClient.setSurname(client.getSurname());
        savedClient.setPhoneNumber(client.getPhoneNumber());

        return savedClient;
    }

    public void deleteClientById(final long id) {
        clients = clients.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }

    public int count(){
        return clients.size();
    }

}
