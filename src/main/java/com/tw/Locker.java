package com.tw;

import lombok.Builder;

@Builder
public class Locker {
    private int capacity;

    public Ticket store(Bag bag) {
        if (capacity==0) {
            throw new RuntimeException("Locker has already full");
        }
        capacity--;
        return Ticket.builder().bagId(bag.getId()).build();
    }
}
