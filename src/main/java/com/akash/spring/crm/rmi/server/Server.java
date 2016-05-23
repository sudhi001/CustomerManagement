package com.akash.spring.crm.rmi.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Created by Akash Agarwal on 5/23/2016.
 */
public class Server {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("file:src\\main\\resources\\spring\\rmi-server-config.xml");
        System.out.println("Server is running, Please hit any key to stop!");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        container.close();
        scanner.close();
    }
}
