
import akka.actor.Actor;
import akka.actor.Props;
import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.ActorContext;

//Actor communication 
//A simple program shows how communication will happen between 
//2 actors and exchange of msg

object ActorCommunication extends App{

  //Msg's defination that actor will handle
    case class startCounting(n:Int, other:ActorRef)
    case class CountDown(n:Int) 

  //Defining an actor
  class countActor extends Actor{
  
    //Method every actor need to implement
    def receive = {
      
        //case class provide pattern matching 
          case startCounting(n,otherActor) => 
                println(n)
                otherActor ! CountDown(n-1)
          case CountDown(n) => 

              //this === self in akka 
              println(self)
                if(n > 0){
                println(n)
                //sender is special keyword which has reference of the actor which sent 
                //msg to our actor
                 sender ! CountDown(n-1)  
                }else{
                //We need to terminate the actor system hence need context
                //so can access the system
                  context.system.terminate()
                }
              
    }
    //end of actor defination
  }


  //Creating actor system
    val system = ActorSystem("CommunicationSystem")
    val actor1 = system.actorOf(Props[countActor],"ActorA")
    val actor2 = system.actorOf(Props[countActor],"ActorB")

    actor1 ! startCounting(10, actor2)
}
