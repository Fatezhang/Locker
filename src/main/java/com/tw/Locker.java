package com.tw;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class Locker {
    private int capacity;
    private final Map<Integer, Bag> bagMap = new HashMap<>();

    public Ticket store(Bag bag) {
        if (capacity==0) {
            throw new RuntimeException("Locker has already full");
        }
        capacity--;
        bagMap.put(bag.getId(), bag);
        return Ticket.builder().bagId(bag.getId()).build();
    }

    public Bag getBag(Ticket ticket) {
        return bagMap.get(ticket.getBagId());
    }
}
