//package com.example.deal.domain;
//
//import com.example.util.DealEvents;
//import com.example.util.DealStates;
//import kalix.javasdk.eventsourcedentity.CommandContext;
//import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.config.StateMachineFactory;
//
//public final class SpringFSMEntityRouter extends SpringFSMEventSourcedRouter<StateMachine<DealStates, DealEvents>, DealEntity> {
//
//    public SpringFSMEntityRouter(StateMachine<DealStates, DealEvents> entity, StateMachineFactory<DealStates, DealEvents> factory) {
//        super(entity, factory);
//    }
//
//    @Override
//    public StateMachine<DealStates, DealEvents> handleEvent(StateMachine<DealStates, DealEvents> state, Object event) {
//        return null;
//    }
//
//    @Override
//    public EventSourcedEntity.Effect handleCommand(String commandName, StateMachine<DealStates, DealEvents> state, Object command, CommandContext context) {
//        return null;
//    }
//}
