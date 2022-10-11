package com.servisofts.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.ConnectionFactory;

public class Receptor {
    private final static String QUEUE_NAME = "queue_de_prueva";
    private static final String EXCHANGE_NAME = "IntegrationEvents.AeronaveCreado";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.3.2");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        DeliverCallback callback = (consumetTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(message);
        };
        channel.basicConsume(QUEUE_NAME, true, callback, consumerTag -> {
            System.out.println("Basic onCancel");
        });
    }
}
