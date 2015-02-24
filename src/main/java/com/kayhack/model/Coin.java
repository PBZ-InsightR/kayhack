package com.kayhack.model;

public class Coin {
    private Long id;
    private Long value;

    public Coin() {
    }

    public Coin(Long id, Long value) {
        this.id = id;
        this.value = value;
        Bank.getInstance().create(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

}
