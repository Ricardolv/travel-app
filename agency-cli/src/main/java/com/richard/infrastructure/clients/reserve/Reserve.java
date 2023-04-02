package com.richard.infrastructure.clients.reserve;

public class Reserve {
    private Long codeCustomer;

    private Reserve(Long codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public static Reserve of(Long codeCustomer) {
        return new Reserve(codeCustomer);
    }

    public Long getCodeCustomer() {
        return codeCustomer;
    }
}
