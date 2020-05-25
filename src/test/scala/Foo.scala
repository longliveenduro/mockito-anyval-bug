import java.util.UUID

import org.specs2.Specification
import org.specs2.matcher.{MatchResult, MustThrownMatchers}
import org.mockito.specs2.Mockito

case class AnyValString(s: String) extends AnyVal

trait Foo {
  def bar(processId: String): String
}

trait ImCom {
  def bar(a: AnyValString): String
}

class FooSpecification extends Specification with Mockito with MustThrownMatchers {
  def is = sequential ^
    s2"""
    Mocking
        works for String ${testFoo()}
        throws NPE for AnyVal ${testAnyVal()}
     """

  def testFoo(): MatchResult[Any] = {
    val fooMock = mock[Foo]
    fooMock.bar(any) returns "answer"

    val s = UUID.randomUUID().toString
    fooMock.bar(s)
    there was one(fooMock).bar(s)
  }

  def testAnyVal(): MatchResult[Any] = {
    val imMock = mock[ImCom]
    imMock.bar(any) returns "answer"

    val s = AnyValString(UUID.randomUUID().toString)
    imMock.bar(s)
    there was one(imMock).bar(s)
  }
}
