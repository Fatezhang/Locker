package com.tw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LockerTest {
    @Test
    public void shouldStoreBagSuccessAndReturnATicket() {
        var locker = Locker.builder().capacity(3).build();
        var bagId = 1;
        var bag = Bag.builder().id(bagId).build();

        var ticket = locker.store(bag);

        var expectedTicket = Ticket.builder().bagId(bagId).build();
        assertThat(ticket).isEqualTo(expectedTicket);
    }
}
