package com.tw;

import lombok.Builder;

@Builder
public class Locker {
    private int capacity;

    public Ticket store(Bag bag) {
        return Ticket.builder().bagId(bag.getId()).build();
    }
}
