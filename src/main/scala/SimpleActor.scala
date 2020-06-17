//A simple program to create an actor and send a msg to an actor

import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.ActorSystem;


//Creating an application by extending App
object SimpleActorExample extends App{

  //declaring an actor
  class SimpleActor extends Actor{

    //Actor method need to implement receive method 
      def receive = {
        case s:String => println("String "+s)
        case i:Int => println("Number "+i)
        case _ => println("A message received")
        //end of receive method 
      }

    //custome method defined inside the actor
      def foo = println("Normal method")

    //end of actor defination
  }

  //Actor System
  //Creating a simple Actor System 
  //Creating a actor on the system 
  val system = ActorSystem("Simple-System");

  //Actor reference is passed to the variable
  val actor = system.actorOf(Props[SimpleActor],"Simple-Actor")


  //sending message to actor on the actor system
  // ! => 
  actor ! "Hii there." 
  actor ! true

  
  //terminate the actor system,as the system is very costly
  system.terminate()
}
