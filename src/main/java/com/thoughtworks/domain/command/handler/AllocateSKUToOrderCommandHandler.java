package com.thoughtworks.domain.command.handler;

import com.thoughtworks.domain.aggregate.Order;
import com.thoughtworks.domain.command.AllocateSKUToOrderCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.common.caching.NoCache;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.CachingEventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Component;

@Component
public class AllocateSKUToOrderCommandHandler {

    private Repository<Order> repository;

    public AllocateSKUToOrderCommandHandler(AggregateFactory facotory, EventBus eventBus) {
        repository = new CachingEventSourcingRepository<Order>(facotory, (EventStore) eventBus, NoCache.INSTANCE);
    }

    @CommandHandler
    public void handle(AllocateSKUToOrderCommand command) {

        Aggregate<Order> orderAggregate = repository.load(command.getOrderId());
        orderAggregate.execute(order -> order.associateSKUs(command.getItemId(), command.getSkus()));

    }
}
