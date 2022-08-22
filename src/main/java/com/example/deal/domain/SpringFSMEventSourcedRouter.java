//package com.example.deal.domain;
//
//import com.example.util.DealEvents;
//import com.example.util.DealStates;
//import kalix.javasdk.eventsourcedentity.CommandContext;
//import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
//import kalix.javasdk.impl.eventsourcedentity.EventSourcedEntityRouter;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.config.StateMachineFactory;
//
//public abstract class SpringFSMEventSourcedRouter<E extends SpringFSMEventSourcedEntity>
//        extends EventSourcedEntityRouter<StateMachine<DealStates, DealEvents>, E> {
//
//    //abstract class EventSourcedEntityRouter[S, E <: kalix.javasdk.eventsourcedentity.EventSourcedEntity[S]](protected val entity : E)
//
//    private final E entity;
//
//    private final StateMachineFactory<DealStates, DealEvents> factory;
//
//    public SpringFSMEventSourcedRouter(E entity, StateMachineFactory<DealStates, DealEvents> factory) {
//        super(entity);
//        this.entity = entity;
//        this.factory = factory;
//    }
//
//}
