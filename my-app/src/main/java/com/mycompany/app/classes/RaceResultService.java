package com.mycompany.app.classes;

import java.util.Collection;
import java.util.HashSet;

import com.mycompany.app.interfaces.Client;
import com.mycompany.app.interfaces.Message;

public class RaceResultService {
    private Collection<Client> clients = new HashSet<Client>();

    public void addSubscriber(Client client) {
        clients.add(client);
    }

    public void send(Message message) {
        for (Client client : clients) {
            client.receive(message);
        }
    }

    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
}
