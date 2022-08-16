package com.example.fsm;

import com.example.util.DealEvents;
import com.example.util.DealStates;
import lombok.extern.java.Log;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.config.common.annotation.EnableAnnotationConfiguration;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;


@Log
@EnableAnnotationConfiguration
@EnableStateMachineFactory
class SimpleStateMachineConfiguration extends StateMachineConfigurerAdapter<DealStates, DealEvents> {

    @Override
    public void configure(StateMachineTransitionConfigurer<DealStates, DealEvents> transitions) throws Exception {
        transitions
                .withExternal().source(DealStates.SUBMITTED).target(DealStates.PAID).event(DealEvents.PAY)
                .and()
                .withExternal().source(DealStates.PAID).target(DealStates.FULFILLED).event(DealEvents.FULFILL)
                .and()
                .withExternal().source(DealStates.SUBMITTED).target(DealStates.CANCELLED).event(DealEvents.CANCEL)
                .and()
                .withExternal().source(DealStates.PAID).target(DealStates.CANCELLED).event(DealEvents.CANCEL);
    }

    @Override
    public void configure(StateMachineStateConfigurer<DealStates, DealEvents> states) throws Exception {
        states
                .withStates()
                .initial(DealStates.SUBMITTED)
                .state(DealStates.PAID)
                .end(DealStates.FULFILLED)
                .end(DealStates.CANCELLED);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<DealStates, DealEvents> config) throws Exception {
        StateMachineListenerAdapter<DealStates, DealEvents> adapter = new StateMachineListenerAdapter<DealStates, DealEvents>() {
            @Override
            public void stateChanged(State<DealStates, DealEvents> from, State<DealStates, DealEvents> to) {
                log.info(String.format("State changed (from: %s, to %s)", from + "", to + ""));
            }
        };
        config.withConfiguration()
                .autoStartup(false)
                .listener(adapter);
    }
}
