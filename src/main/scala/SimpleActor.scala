
import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.ActorSystem;


// This is a singleton object which extends the trail ? App so
// that it will 
// Add the reasons why we need to extends with App
// Why we need only object not class
object SimpleActorExample extends App{

  //declaring an actor
  class SimpleActor extends Actor{

    //Actor method need to implement
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
  val system = ActorSystem("Simple-System");
  val actor = system.actorOf(Props[SimpleActor],"Simple-Actor")


  //sending message to actor on the actor system
  actor ! "Hii there." 
  actor ! true
}
