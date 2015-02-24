package com.kayhack.server;


import com.kayhack.server.resource.BankResource;
import com.kayhack.server.resource.BankTotalAmountResource;
import com.kayhack.server.resource.CoinResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class KayHackApplication extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/rest/operationList", BankResource.class);
        router.attach("/rest/totalAmount", BankTotalAmountResource.class);
        router.attach("/rest/deposit/{coinId}", CoinResource.class);
        return router;
    }
}