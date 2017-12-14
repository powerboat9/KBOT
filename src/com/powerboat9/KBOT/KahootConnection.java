package com.powerboat9.KBOT;

import org.cometd.bayeux.Channel;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;
import org.cometd.client.transport.LongPollingTransport;
import org.eclipse.jetty.client.HttpClient;

import java.util.HashMap;

public class KahootConnection {
    private int id;

    private BayeuxClient bClient;
    private ClientTransport transport;

    private KahootConnection(int idIn) throws Exception {
        id = idIn;
        HashMap<String, Object> ops = new HashMap<>();
        HttpClient httpClient = new HttpClient();
        httpClient.start();
        transport = new LongPollingTransport(ops, httpClient);
        bClient = new BayeuxClient("https://kahoot.it:8080/cometd", transport);
        bClient.getChannel(Channel.META).addListener((ClientSessionChannel.MessageListener) (clientSessionChannel, message) -> {
            if (message.isSuccessful()) System.out.println(message.getData());
        });
        bClient.handshake();
    }

    public static KahootConnection getInstance(int id) {
        try {
            return new KahootConnection(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isConnected() {
        return bClient.isConnected();
    }
}
