import akka.actor.{Actor, ActorRef}

class Ping(pong: ActorRef) extends Actor {
  var count = 0

  def incrementAndPrint {
    count += 1;
    println("ping")
  }
  def receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage
    case PongMessage =>
      incrementAndPrint
      if (count > 99) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
        420
      }
    case _ => println("Ping got something unexpected.")
  }
}