package com.richard.infrastructure.clients.reserve;

public class Reserve {
    private String nameCustomer;

    private Reserve(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public static Reserve of(String nameCustomer) {
        return new Reserve(nameCustomer);
    }

    public String getNameCustomer() {
        return nameCustomer;
    }
}
