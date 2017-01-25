package com.thoughtworks.domain.aggregate;


import com.thoughtworks.domain.command.CreateOrderCommand;
import com.thoughtworks.domain.event.OrderCreatedEvent;
import com.thoughtworks.domain.event.OrderItemAssociatedToSKUEvent;
import com.thoughtworks.domain.model.Item;
import com.thoughtworks.domain.model.SKU;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Order {

    @AggregateIdentifier
    private String id;


    private Map<String, Item> items;


    //required by axon
    public Order() {
    }

    public void associateSKUs(String itemId, List<SKU> skus) {

        apply(new OrderItemAssociatedToSKUEvent(id, itemId, skus));
    }


    @CommandHandler
    public Order(CreateOrderCommand command) {
        apply(new OrderCreatedEvent(command.getOrderId(), command.getItems()));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.id = event.getId();
        items = event.getItems().stream().collect(Collectors.toMap(item -> item.getIdentifier(),item -> item ));
    }

    @EventSourcingHandler
    public void on(OrderItemAssociatedToSKUEvent event) {
        Item item = items.get(event.getItemId());
        item.associateSKUs(event.getSkus());

    }

}
