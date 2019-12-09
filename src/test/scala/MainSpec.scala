import akka.actor.ActorSystem
import akka.testkit.TestKit
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class MainSpec extends TestKit(ActorSystem()) with AnyFlatSpecLike with Matchers with BeforeAndAfterAll {

  override def afterAll(): Unit =
    shutdown(system)

  "This test" should "do nothing" in {}
}
