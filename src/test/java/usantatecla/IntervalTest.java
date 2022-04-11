package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {


  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);
  private IntervalBuilder intervalBuilder;
  private IntervalBuilder intervalBuilder2;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
    this.intervalBuilder2 = new IntervalBuilder();
  }

  @Test
  public void  givenIntervalWhenIntersectWithIntervalWithinThenTrue() {

    Interval interval1 = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Interval interval2 = this.intervalBuilder2.closed(left.getGreater()).closed(right.getLess()).build();
    assertTrue(interval1.intersect(interval2));

  }
  @Test
  public void givenIntervalWhenIntersectWithIntervalOutsideThenFalse() {

    Interval interval1 = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Interval interval2 = this.intervalBuilder2.closed(right.getGreater()).closed(right.getGreater()).build();
    assertFalse(interval1.intersect(interval2));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervalWhenIntersectWithIntervalLimitValueThenTrue() {
    Interval interval1 = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Interval interval2 = this.intervalBuilder2.closed(right.getEquals()).closed(right.getGreater()).build();
    assertTrue(interval1.intersect(interval2));
  }

  @Test
  public void givenIntervalWhenIntersectWithIntervalPartiallyWithinThenTrue() {
    Interval interval1 = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Interval interval2 = this.intervalBuilder2.closed(left.getGreater()).closed(right.getGreater()).build();
    assertTrue(interval1.intersect(interval2));
  }

  @Test
  public void givenIntervalClosedWhenIntersectWithIntervalOpenLimitValueThenFalse() {
    Interval interval1 = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    Interval interval2 = this.intervalBuilder2.open(right.getEquals()).closed(right.getGreater()).build();
    assertFalse(interval1.intersect(interval2));
  }

  @Test
  public void givenIntervalOpenWhenIntersectWithIntervalClosedLimitValueThenFalse() {
    Interval interval1 = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
    Interval interval2 = this.intervalBuilder2.closed(right.getEquals()).closed(right.getGreater()).build();
    assertFalse(interval1.intersect(interval2));
  }

  @Test
  public void givenIntervalOpenWhenIntersectWithIntervalOpenLimitValueThenFalse() {
    Interval interval1 = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
    Interval interval2 = this.intervalBuilder2.open(right.getEquals()).closed(right.getGreater()).build();
    assertFalse(interval1.intersect(interval2));
  }



}