package com.akka.actors;
import akka.actor.UntypedActor;
public class Consumer extends UntypedActor {
    @Override
    public void onReceive(Object msg) throws Exception {
        if(msg instanceof Integer) {
            System.out.println("<<< Receiving in Consumer " + msg);
        }
    }
}
