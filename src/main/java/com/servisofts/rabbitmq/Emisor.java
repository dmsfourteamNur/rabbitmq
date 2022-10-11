package com.servisofts.rabbitmq;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.ConnectionFactory;

public class Emisor {
    private static final String EXCHANGE_NAME = "dmsnur_exchange";

    public static void main(String[] args) throws Exception {

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("192.168.3.2");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            // channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            String message = "Hellow world";
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Mensagge enviado");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
