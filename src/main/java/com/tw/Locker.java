package com.tw;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Builder
public class Locker {
    private int capacity;
    private final Map<Integer, Bag> bagMap = new HashMap<>();

    public Ticket store(Bag bag) {
        checkCapacity();
        if (bagMap.containsKey(bag.getId())) {
            throw new RuntimeException("Bag has been stored");
        }
        bagMap.put(bag.getId(), bag);
        return Ticket.builder().bagId(bag.getId()).build();
    }

    private void checkCapacity() {
        if (capacity == bagMap.size()) {
            throw new RuntimeException("Locker has already full");
        }
    }

    public Bag getBag(Ticket ticket) {
        if (!bagMap.containsKey(ticket.getBagId())) {
            throw new RuntimeException("Ticket is invalid!");
        }
        return bagMap.remove(ticket.getBagId());
    }
}
