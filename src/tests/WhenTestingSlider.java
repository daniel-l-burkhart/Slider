/**
 *
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

import model.Direction;
import model.Slider;

/**
 * The test class for the Slider.
 *
 * @author danielburkhart
 * @version Fall 2015
 *
 */
public class WhenTestingSlider {

	/**
	 * Test (f) an initial slider should have a score 0.
	 */
	@Test
	public void whenInitialSliderScoreShouldEqualZero() {
		Slider newSlider = new Slider();
		assertEquals(0, newSlider.score());
	}

	/**
	 * Test (a)
	 */
	@Test
	public void whenInitialCallShouldBeSolved() {
		Slider newSlider = new Slider();
		assertTrue(newSlider.solved());
	}

	/**
	 * Test (b) an initial slider should allow up.
	 */
	@Test
	public void whenInitialCallShouldAllowUp() {
		Slider newSlider = new Slider();
		assertTrue(newSlider.canMoveUp());
	}

	/**
	 * Test (c) an initial slider should allow left.
	 */
	@Test
	public void whenInitialCallShouldAllowLeft() {
		Slider newSlider = new Slider();
		assertTrue(newSlider.canMoveLeft());
	}

	/**
	 * Test (d) an initial slider should not allow down.
	 */
	@Test
	public void whenInitialCallShouldNotAllowDown() {
		Slider newSlider = new Slider();
		assertFalse(newSlider.canMoveDown());
	}

	/**
	 * Test (e) an initial slider should not allow right.
	 */
	@Test
	public void whenInitialCallShouldNotAllowRight() {
		Slider newSlider = new Slider();
		assertFalse(newSlider.canMoveRight());
	}

	/**
	 * Test (g) an initial slider should not be solved after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldNotBeSolved() {
		Slider newSlider = new Slider();

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.LEFT);

		newSlider = newSlider.move(Direction.LEFT);

		assertFalse(newSlider.solved());
	}

	/**
	 * Test (h) an initial slider should not allow up after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldNotAllowMoveUp() {
		Slider newSlider = new Slider();

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.LEFT);

		newSlider = newSlider.move(Direction.LEFT);

		assertFalse(newSlider.canMoveUp());
	}

	/**
	 * Test (i) an initial slider should not allow left after up, up, left,
	 * left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldNotAllowMoveLeft() {
		Slider newSlider = new Slider();

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.LEFT);

		newSlider = newSlider.move(Direction.LEFT);

		assertFalse(newSlider.canMoveLeft());
	}

	/**
	 * Test (j) an initial slider should allow down after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldAllowMoveDown() {
		Slider newSlider = new Slider();

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.LEFT);

		newSlider = newSlider.move(Direction.LEFT);

		assertTrue(newSlider.canMoveDown());
	}

	/**
	 * Test (k) an initial slider should allow right after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldAllowMoveRight() {
		Slider newSlider = new Slider();

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.LEFT);

		newSlider = newSlider.move(Direction.LEFT);

		assertTrue(newSlider.canMoveRight());
	}

	/**
	 * Test (l) an initial slider should have a score of 8 after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldHaveAScoreOfEight() {
		Slider newSlider = new Slider();

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.UP);

		newSlider = newSlider.move(Direction.LEFT);

		newSlider = newSlider.move(Direction.LEFT);

		assertEquals(8, newSlider.score());
	}

	/**
	 * An initial slider should evaluate to 87654321.
	 */
	@Test
	public void sliderWithNoMovesShouldHashTo87654321() {

		Slider aSlider = new Slider();

		assertEquals(87654321, aSlider.hashCode());
	}

	/**
	 * Sliders with different moves should still be the same hash wise and be
	 * equal.
	 */
	@Test
	public void slidersWithDifferentMovesShouldHashTheSame() {

		Slider aSlider = new Slider();

		aSlider = aSlider.move(Direction.UP);
		aSlider = aSlider.move(Direction.UP);
		aSlider = aSlider.move(Direction.LEFT);
		aSlider = aSlider.move(Direction.LEFT);

		Slider bSlider = new Slider();

		bSlider = bSlider.move(Direction.UP);
		bSlider = bSlider.move(Direction.UP);
		bSlider = bSlider.move(Direction.LEFT);
		bSlider = bSlider.move(Direction.LEFT);
		bSlider.clearMoves();

		assertTrue(aSlider.hashCode() == bSlider.hashCode());
	}

	/**
	 * The difference between moves put in hashSet should be 1.
	 */
	@Test
	public void slidersWithDifferentMovesPutInHashSetShouldBeSize1() {

		Slider aSlider = new Slider();

		aSlider = aSlider.move(Direction.UP);
		aSlider = aSlider.move(Direction.UP);
		aSlider = aSlider.move(Direction.LEFT);
		aSlider = aSlider.move(Direction.LEFT);

		Slider bSlider = new Slider();

		bSlider = bSlider.move(Direction.UP);
		bSlider = bSlider.move(Direction.UP);
		bSlider = bSlider.move(Direction.LEFT);
		bSlider = bSlider.move(Direction.LEFT);

		bSlider.clearMoves();

		HashSet<Slider> aSet = new HashSet<>();
		aSet.add(aSlider);
		aSet.add(bSlider);

		assertEquals(1, aSet.size());
	}

}
