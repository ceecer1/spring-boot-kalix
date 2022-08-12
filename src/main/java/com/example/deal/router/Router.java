package com.example.deal.router;

import com.example.deal.fsm.FSMEventSourcedEntity;
import com.example.deal.util.DealEvents;
import com.example.deal.util.DealStates;
import kalix.EventSourcedEntity;
import kalix.javasdk.eventsourcedentity.CommandContext;
import kalix.javasdk.impl.eventsourcedentity.EventSourcedEntityRouter;
import org.springframework.statemachine.config.StateMachineFactory;

public final class Router<E extends FSMEventSourcedEntity> extends EventSourcedEntityRouter<Object, E> {

    private final E entity;

    private final StateMachineFactory<DealStates, DealEvents> factory;

    public Router(E entity, StateMachineFactory<DealStates, DealEvents> factory) {
        super(entity);
        this.entity = entity;
        this.factory = factory;
    }

    @Override
    public Object handleEvent(Object state, Object event) {
        return null;
    }

    @Override
    public kalix.javasdk.eventsourcedentity.EventSourcedEntity.Effect handleCommand(String commandName, Object state, Object command, CommandContext context) {
        return null;
    }
}
