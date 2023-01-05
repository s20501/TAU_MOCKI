package com.mycompany.app.classes;

import com.mycompany.app.interfaces.Client;
import com.mycompany.app.interfaces.MailServer;
import com.mycompany.app.interfaces.Template;
import com.mycompany.app.interfaces.TemplateEngine;

public class Messenger {
    private TemplateEngine templateEngine;
    private MailServer mailServer;

    public Messenger(MailServer mailServer, TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    public void sendMessage(Client client, Template template) {
        String msgContent = templateEngine.prepareMessage(template, client);
        mailServer.send(client.getEmail(), msgContent);
    }

}