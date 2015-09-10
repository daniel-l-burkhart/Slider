/**
 * 
 */
package tests;

import static org.junit.Assert.*;

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
	 * Test (f) an initial slider should have a score 0.
	 */
	@Test
	public void whenInitialSliderScoreShouldEqualZero() {
		Slider newSlider = new Slider();
		assertEquals(newSlider.score(), 0);
	}

	/**
	 * Test (g) an initial slider should not be solved after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldNotBeSolved() {
		Slider newSlider = new Slider();
		newSlider.move(Direction.UP);
		newSlider.move(Direction.UP);
		newSlider.move(Direction.LEFT);
		newSlider.move(Direction.LEFT);
		assertFalse(newSlider.solved());
	}

	/**
	 * Test (h) an initial slider should not allow up after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldNotAllowMoveUp() {
		Slider newSlider = new Slider();
		newSlider.move(Direction.UP);
		newSlider.move(Direction.UP);
		newSlider.move(Direction.LEFT);
		newSlider.move(Direction.LEFT);
		assertFalse(newSlider.canMoveUp());
	}

	/**
	 * Test (i) an initial slider should not allow left after up, up, left,
	 * left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldNotAllowMoveLeft() {
		Slider newSlider = new Slider();
		newSlider.move(Direction.UP);
		newSlider.move(Direction.UP);
		newSlider.move(Direction.LEFT);
		newSlider.move(Direction.LEFT);
		assertFalse(newSlider.canMoveLeft());
	}

	/**
	 * Test (j) an initial slider should allow down after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldAllowMoveDown() {
		Slider newSlider = new Slider();
		newSlider.move(Direction.UP);
		newSlider.move(Direction.UP);
		newSlider.move(Direction.LEFT);
		newSlider.move(Direction.LEFT);
		assertTrue(newSlider.canMoveDown());
	}

	/**
	 * Test (k) an initial slider should allow down after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldAllowMoveRight() {
		Slider newSlider = new Slider();
		newSlider.move(Direction.UP);
		newSlider.move(Direction.UP);
		newSlider.move(Direction.LEFT);
		newSlider.move(Direction.LEFT);
		assertTrue(newSlider.canMoveRight());
	}

	/**
	 * Test (l) an initial slider should allow down after up, up, left, left.
	 */
	@Test
	public void whenMovingUpUpLeftLeftShouldHaveAScoreOfEight() {
		Slider newSlider = new Slider();
		newSlider.move(Direction.UP);
		newSlider.move(Direction.UP);
		newSlider.move(Direction.LEFT);
		newSlider.move(Direction.LEFT);
		assertEquals(newSlider.score(), 8);
	}

}
