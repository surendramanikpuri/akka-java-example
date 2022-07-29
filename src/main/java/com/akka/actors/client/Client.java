package com.akka.actors.client;

import com.akka.actors.types.FirstClassicActor;
import com.akka.actors.types.MyActor;
import com.akka.actors.types.PrinterActor;
import com.akka.actors.types.ReadingActor;
import com.akka.actors.types.WordCounterActor;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
public class Client {
    public static void main(String[] args) throws InterruptedException {
        ActorSystem system = ActorSystem.create("generate-numbers-one-to-ten");
        
        
        System.out.println("===== Finished producing & sending numbers 1 to 10");
        
        ActorRef classicConsumer = system.actorOf(Props.create(FirstClassicActor.class));
        classicConsumer.tell(1, ActorRef.noSender());
        
        
        ActorRef myActorConsumer = system.actorOf(Props.create(MyActor.class));
        myActorConsumer.tell(1, ActorRef.noSender());
        
        ActorRef printConsumer = system.actorOf(Props.create(PrinterActor.class));
        printConsumer.tell(1, ActorRef.noSender());
        
        ActorRef wordConsumer = system.actorOf(Props.create(WordCounterActor.class));
        wordConsumer.tell(1, ActorRef.noSender());
        
        ActorRef readingConsumer = system.actorOf(Props.create(ReadingActor.class));
        readingConsumer.tell("Text to read", ActorRef.noSender());
        
        
        system.stop(classicConsumer);
    }
}
