import akka.actor.{ActorRef, ActorSystem, Props}
import akka.testkit.TestKit
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, Matchers}

class MainSpec(_system: ActorSystem) extends TestKit(_system) with FlatSpecLike with Matchers with BeforeAndAfterAll {

  def this() = this(ActorSystem("TestSystem"))

  override def afterAll(): Unit = {
    shutdown(system)
  }

  "This test" should "do nothing" in {

  }
}
