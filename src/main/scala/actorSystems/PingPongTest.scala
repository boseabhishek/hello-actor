import akka.actor._


case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage


object PingPongTest extends App {
  val system = ActorSystem("PingPongSystem")

  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  // start the action
  ping ! StartMessage
  // commented-out so you can see all the output
  system.shutdown
}