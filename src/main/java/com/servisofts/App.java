package com.servisofts;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.newConnection()) {

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
