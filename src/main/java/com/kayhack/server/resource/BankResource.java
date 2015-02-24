package com.kayhack.server.resource;


import com.kayhack.model.Bank;
import com.kayhack.model.Coin;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.io.IOException;

public class BankResource extends ServerResource {
    private final Bank repository = Bank.getInstance();

    @Get
    public Representation list() {
        return new JacksonRepresentation<>(Bank.getInstance().list());
    }

    @Post("json")
    public void create(Representation representation) throws IOException {
        JacksonRepresentation<Coin> jsonRepresentation = new JacksonRepresentation<>(representation, Coin.class);
        Coin coin = jsonRepresentation.getObject();
        repository.create(coin);
    }
}
