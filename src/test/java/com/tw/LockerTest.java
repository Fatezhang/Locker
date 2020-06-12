package com.tw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LockerTest {
    @Test
    public void shouldStoreBagSuccessGivenEmptyLockerThenReturnATicket() {
        var locker = Locker.builder().capacity(3).build();
        var bagId = 1;
        var bag = Bag.builder().id(bagId).build();

        var ticket = locker.store(bag);

        var expectedTicket = Ticket.builder().bagId(bagId).build();
        assertThat(ticket).isEqualTo(expectedTicket);
    }

    @Test
    public void shouldStoreBagSuccessGivenLockerJustHave1SpaceThenReturnATicket() {
        var locker = Locker.builder().capacity(3).build();
        var bag1Id = 1;
        var bag2Id = 2;
        var bag3Id = 3;
        var bag1 = Bag.builder().id(bag1Id).build();
        var bag2 = Bag.builder().id(bag2Id).build();
        var bag3 = Bag.builder().id(bag3Id).build();

        locker.store(bag1);
        locker.store(bag2);
        var ticket = locker.store(bag3);

        var expectedTicket = Ticket.builder().bagId(bag3Id).build();
        assertThat(ticket).isEqualTo(expectedTicket);
    }
}
