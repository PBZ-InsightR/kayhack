package com.kayhack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {
    private static final Map<Long, Coin> REPOSITORY = new ConcurrentSkipListMap<>();
    private static final AtomicLong IDS = new AtomicLong(0);

    private static final Bank INSTANCE = new Bank();

    public static Bank getInstance() {
        return INSTANCE;
    }

    private Bank() {
    }

    public List<Coin> list() {
        return new ArrayList<>(REPOSITORY.values());
    }

    public Coin getCoin(Long id) {
        return REPOSITORY.get(id);
    }

    public void create(Coin coin) {
        long id = IDS.getAndIncrement();
        coin.setId(id);
        REPOSITORY.put(id, coin);
    }

    public Long getTotalAmount() {
        Long amount = 0l;
        for (Coin coin : getInstance().list()) {
            amount += coin.getValue();
        }
        return amount;
    }

    public boolean addCoin(Coin coin) {
        return REPOSITORY.put(coin.getId(), coin) != null;
    }

    public boolean removeCoin(Long id) {
        return REPOSITORY.remove(id) != null;
    }
}
