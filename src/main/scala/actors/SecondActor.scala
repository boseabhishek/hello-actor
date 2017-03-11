package actors

import akka.actor.{Actor, ActorRef}

class SecondActor(actorRef: ActorRef) extends Actor{

    def receive = {
      case "hello" => println("SecondActor -hello back at you"); actorRef ! "hello"
      case _ => println("SecondActor -I don't know")
    }

  }
