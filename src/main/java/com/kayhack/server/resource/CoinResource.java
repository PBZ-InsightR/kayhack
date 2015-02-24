package com.kayhack.server.resource;


import com.kayhack.model.Bank;
import com.kayhack.model.Coin;
import org.restlet.data.Status;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.io.IOException;

public class CoinResource extends ServerResource {
    private final Bank repository = Bank.getInstance();

    private Long coinId;

    @Override
    protected void doInit() throws ResourceException {
        System.out.printf("doInit - id={%s}\n", getAttribute("coinId"));
        this.coinId = Long.valueOf(getAttribute("coinId"));
    }

    @Get
    public Representation get() {
        Coin Coin = repository.getCoin(coinId);
        if (Coin == null) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return new JacksonRepresentation<>(Coin);
    }

    @Override
    @Post("json")
    protected Representation post(Representation representation) throws ResourceException {
        try {
            JacksonRepresentation<Coin> jsonRepresentation = new JacksonRepresentation<>(representation, Coin.class);
            Coin coin = jsonRepresentation.getObject();
            repository.addCoin(coin);
            return jsonRepresentation;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

