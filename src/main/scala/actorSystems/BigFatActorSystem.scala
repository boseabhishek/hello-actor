/**
  * The API documentation describes an ActorSystem like this:
“An actor system is a hierarchical group of actors which share common configuration,
e.g. dispatchers, deployments, remote capabilities and addresses. It is also the entry point
for creating or looking up actors.”

An ActorSystem is the structure that allocates one or more threads for your application,
so you typically create one ActorSystem per (logical) application.
  */


package actorSystems


import actors.{HelloActor, SecondActor}
import akka.actor.ActorSystem
import akka.actor.Props


object BigFatActorSystem extends App {
  // an actor needs an ActorSystem
  val system = ActorSystem("any-name")

  //create and start the actor
  //helloActor is a handle to the Actor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

  val secondActor = system.actorOf(Props(new SecondActor(helloActor)), name = "secondactor")

  // an actor whose constructor takes one argument, the actor HelloActor( myName: String) needs to be parameterised
  //val helloActor = system.actorOf(Props(new HelloActor("Fred")), name = "helloactor")

  // send hello actor two messages
  //helloActor ! "hello"
  //helloActor ! "any other message"

  // send second actor two messages
  secondActor ! "hello"
  //secondActor ! "any other message"

  // shut down the system
  system.shutdown
}