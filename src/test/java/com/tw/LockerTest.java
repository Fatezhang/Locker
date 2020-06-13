package com.tw;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LockerTest {
    @Test
    public void shouldStoreBagSuccessAndReturnATicketWhenStoreGivenEmptyLocker() {
        var locker = Locker.builder().capacity(3).build();
        var bagId = 1;
        var bag = Bag.builder().id(bagId).build();

        var ticket = locker.store(bag);

        var expectedTicket = Ticket.builder().bagId(bagId).build();
        assertThat(ticket).isEqualTo(expectedTicket);
    }

    @Test
    public void shouldStoreBagSuccessAndReturnATicketWhenStoreGivenLockerJustHave1Space() {
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

    @Test
    public void shouldThrowExceptionWhenStoreGivenLockerWithoutSpace() {
        var locker = Locker.builder().capacity(2).build();
        var bag1Id = 1;
        var bag2Id = 2;
        var bag3Id = 3;
        var bag1 = Bag.builder().id(bag1Id).build();
        var bag2 = Bag.builder().id(bag2Id).build();
        var bag3 = Bag.builder().id(bag3Id).build();

        locker.store(bag1);
        locker.store(bag2);

        assertThatThrownBy(() -> locker.store(bag3)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void shouldGetBagSuccessWhenGetBagGivenValidTicketAndLockerWithSpecificBag() {
        var locker = Locker.builder().capacity(2).build();
        var bag1Id = 1;
        var bag2Id = 2;
        var bag1 = Bag.builder().id(bag1Id).build();
        var bag2 = Bag.builder().id(bag2Id).build();
        var ticket = Ticket.builder().bagId(bag1Id).build();

        locker.store(bag1);
        locker.store(bag2);

        var bag = locker.getBag(ticket);

        assertThat(bag).isEqualTo(bag1);
    }

    @Test
    public void shouldThrowExceptionWhenGetBagGivenInvalidTicketAndLocker() {
        var locker = Locker.builder().capacity(2).build();
        var bag1Id = 1;
        var bag2Id = 2;
        var bag1 = Bag.builder().id(bag1Id).build();
        var bag2 = Bag.builder().id(bag2Id).build();
        var invalidBagId = 3;
        var ticket = Ticket.builder().bagId(invalidBagId).build();

        locker.store(bag1);
        locker.store(bag2);

        assertThatThrownBy(() -> locker.getBag(ticket)).isInstanceOf(RuntimeException.class);
    }
}
