package ic.doc.strategy;

import org.junit.Test;

import static ic.doc.matchers.IterableBeginsWith.beginsWith;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class TriangleNumbersSequenceTest {

  final TriangleNumbersSequence triangleNumbersSequence = new TriangleNumbersSequence();
  final Sequence sequence = new Sequence(triangleNumbersSequence);

  @Test
  public void definesFirstTermToBeOne() {
    assertThat(sequence.sequence.term(0), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeHalfProductOfNextTwoIndices() {
    assertThat(sequence.sequence.term(1), is(3));
    assertThat(sequence.sequence.term(2), is(6));
    assertThat(sequence.sequence.term(3), is(10));
    assertThat(sequence.sequence.term(4), is(15));
  }

  @Test
  public void isUndefinedForNegativeIndices() {

    try {
      sequence.sequence.term(-1);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
    }
  }

  @Test
  public void canBeIteratedThrough() {
    assertThat(sequence, beginsWith(1, 3, 6, 10, 15));
  }
}
