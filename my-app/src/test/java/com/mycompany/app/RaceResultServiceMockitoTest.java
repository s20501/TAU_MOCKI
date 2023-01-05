package com.mycompany.app;

import org.junit.Test;
import static org.mockito.Mockito.*;

import com.mycompany.app.classes.RaceResultService;
import com.mycompany.app.interfaces.Client;
import com.mycompany.app.interfaces.Message;

public class RaceResultServiceMockitoTest {
    @Test
    public void testSend() {
        Client client = mock(Client.class);

        RaceResultService service = new RaceResultService();
        service.addSubscriber(client);

        Message message = mock(Message.class);

        service.send(message);

        verify(client).receive(message);
    }
}
