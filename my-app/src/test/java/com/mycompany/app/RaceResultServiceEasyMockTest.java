package com.mycompany.app;

import static org.easymock.EasyMock.*;

import org.junit.Test;

import com.mycompany.app.classes.RaceResultService;
import com.mycompany.app.interfaces.Client;
import com.mycompany.app.interfaces.Message;

public class RaceResultServiceEasyMockTest {
    @Test
    public void testSend() {
        Client client = createMock(Client.class);

        RaceResultService service = new RaceResultService();
        service.addSubscriber(client);

        Message message = createMock(Message.class);

        client.receive(message);
        expectLastCall();

        replay(client, message);

        service.send(message);

        verify(client, message);
    }
}
