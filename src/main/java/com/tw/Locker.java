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
        if (capacity == 0) {
            throw new RuntimeException("Locker has already full");
        }
        Optional.ofNullable(bagMap.get(bag.getId())).ifPresent(oldBag -> {
            throw new RuntimeException("Bag has benn stored");
        });
        capacity--;
        bagMap.put(bag.getId(), bag);
        return Ticket.builder().bagId(bag.getId()).build();
    }

    public Bag getBag(Ticket ticket) {
        var bag = bagMap.get(ticket.getBagId());
        return Optional.ofNullable(bag).orElseThrow(RuntimeException::new);
    }
}
