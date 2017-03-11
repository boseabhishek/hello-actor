package actors

import akka.actor.Actor

class HelloActor extends Actor {

    def receive = {
      case "hello" => println("hello back at you"); sender ! "To the sender!"
      case _ => println("I don't know")
    }

}
