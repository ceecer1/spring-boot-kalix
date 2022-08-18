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
//public final class SpringFSMEventSourcedRouter<E extends SpringFSMEventSourcedEntity>
//        extends EventSourcedEntityRouter<StateMachine<DealStates, DealEvents>, E> {
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
////    @Override
////    public StateMachine<DealStates, DealEvents> handleEvent(StateMachine<DealStates, DealEvents> state, Object event) {
////        if (event instanceof DealDomain.DealSubmitted) {
////            return entity().dealSubmitted(state, (DealDomain.DealSubmitted) event);
////        } else if (event instanceof DealDomain.DealPaid) {
////            return entity().dealPaid(state, (DealDomain.DealPaid) event);
////        } else if (event instanceof DealDomain.DealFulfilled) {
////            return entity().dealFulfilled(state, (DealDomain.DealFulfilled) event);
////        } else if (event instanceof DealDomain.DealCancelled) {
////            return entity().dealCancelled(state, (DealDomain.DealCancelled) event);
////        } else {
////            throw new EventHandlerNotFound(event.getClass());
////        }
////    }
//
//    @Override
//    public EventSourcedEntity.Effect handleCommand(String commandName, StateMachine<DealStates, DealEvents> state, Object command, CommandContext context) {
//        return null;
//    }
//}
