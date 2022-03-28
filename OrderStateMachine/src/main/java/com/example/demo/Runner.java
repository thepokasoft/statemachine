package com.example.demo;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Log
@Component
public class Runner implements ApplicationRunner{
	
	private final StateMachineFactory<OrderStates, OrderEvents> factory; 
	Runner(StateMachineFactory<OrderStates, OrderEvents> factory){
		this.factory=factory;
	}
	
	public void run(ApplicationArguments args) throws Exception {
		StateMachine<OrderStates, OrderEvents> machine = this.factory.getStateMachine("12345");
		machine.start();
		log.info("Current state:" +machine.getState().getId().name());
		machine.sendEvent(OrderEvents.PAY);
		log.info("Current state:" +machine.getState().getId().name());
		machine.sendEvent(OrderEvents.FULFILL);
		log.info("Current state:" +machine.getState().getId().name());
	}

}
