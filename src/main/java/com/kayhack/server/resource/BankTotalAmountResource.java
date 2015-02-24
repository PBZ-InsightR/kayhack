package com.kayhack.server.resource;

import com.kayhack.model.Bank;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class BankTotalAmountResource extends ServerResource {
    @Get
    public Representation getTotalAmount() {
        return new JacksonRepresentation<>(new BankTotalAmountBean(Bank.getInstance()));
    }

    private class BankTotalAmountBean {
        private final Long totalAmount;

        private BankTotalAmountBean(Bank bank) {
            totalAmount = bank.getTotalAmount();
        }

        public Long getTotalAmount() {
            return totalAmount;
        }
    }
}
