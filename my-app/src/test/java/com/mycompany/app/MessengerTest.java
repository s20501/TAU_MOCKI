package com.mycompany.app;

import com.mycompany.app.classes.Messenger;
import com.mycompany.app.interfaces.Client;
import com.mycompany.app.interfaces.MailServer;
import com.mycompany.app.interfaces.Template;
import com.mycompany.app.interfaces.TemplateEngine;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class MessengerTest {
    @Test
    public void testSendMessage() {
        MailServer mailServer = mock(MailServer.class);
        TemplateEngine templateEngine = mock(TemplateEngine.class);
        Client client = mock(Client.class);
        Template template = mock(Template.class);

        when(client.getEmail()).thenReturn("adam@example.com");
        when(template.getTemplateText()).thenReturn("Template text");
        when(templateEngine.prepareMessage(template, client)).thenReturn("message");

        Messenger messenger = new Messenger(mailServer, templateEngine);
        messenger.sendMessage(client, template);

        verify(templateEngine).prepareMessage(template, client);
        verify(mailServer).send("adam@example.com", "message");
    }
}