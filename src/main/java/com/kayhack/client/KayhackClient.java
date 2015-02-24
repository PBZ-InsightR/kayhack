package com.kayhack.client;


import org.restlet.resource.ClientResource;

import java.io.IOException;

public class KayhackClient {
    private static final int PORT = 8082;
    private static final String BASE_URL = "http://localhost";

    public static void main(String[] args) throws IOException {
        depositCoin(1, 10l);
        depositCoin(2, 15l);
        retrieveBankOperationList();
        retrieveBankAmount();
    }

    private static void retrieveBankAmount() throws IOException {
        ClientResource resource = new ClientResource(BASE_URL + ":" + PORT + "/rest/totalAmount");
        resource.get();
        resource.getResponseEntity().write(System.out);
    }

    private static void retrieveBankOperationList() throws IOException {
        ClientResource resource = new ClientResource(BASE_URL + ":" + PORT + "/rest/operationList");
        resource.get();
        resource.getResponseEntity().write(System.out);
    }

    private static void depositCoin(int id, Long value) throws IOException {
        ClientResource resource = new ClientResource(BASE_URL + ":" + PORT + "/rest/deposit/" + id);
        String json = String.format("{\"id\":\"%s\", \"value\":\"%s\"}", id, value);
        System.out.println("envoie de : " + json);
        resource.post(json);
        resource.getResponseEntity().write(System.out);
    }
}