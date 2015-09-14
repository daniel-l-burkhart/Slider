/**
 *
 */
package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Direction;
import model.Slider;
import model.SliderAStar;

/**
 * The test class for the AStar Search Algorithm
 *
 * @author dburkha1
 * @version Fall 2015
 *
 */
public class TestingSliderAStar {

	/**
	 * Test the simple puzzle.
	 */
	@Test
	public void testSimplePuzzle() {

		int[] initialBoard = { 4, 1, 2, 7, 5, 3, 8, 0, 6 };
		Slider aSlider = new Slider(initialBoard);

		SliderAStar aStar = new SliderAStar(aSlider);

		ArrayList<Direction> moves = aStar.solve();

		System.out.println("Simple Puzzle");
		System.out.println("---");
		for (Direction aMove : moves) {
			System.out.println(aMove);
		}

		assertEquals(7, moves.size());
	}

	/**
	 * Test a puzzle with a different initial state.
	 * Puzzle arrangement:
	 * 5767814320
	 */
	@Test
	public void test5767814320() {
		int[] initialBoard = { 5, 7, 6, 8, 1, 4, 3, 2, 0 };
		Slider aSlider = new Slider(initialBoard);

		SliderAStar aStar = new SliderAStar(aSlider);
		ArrayList<Direction> moves = aStar.solve();

		System.out.println("---");
		System.out.println("5767814320");
		System.out.println("---");
		for (Direction aMove : moves) {
			System.out.println(aMove);
		}

		System.out.println("Solved in # moves: " + moves.size());
	}

	/**
	 * Tests another initial state of the 8-puzzle.
	 * Puzzle arrangement:
	 * 876543210
	 */
	@Test
	public void test876543210() {
		int[] initialBoard = { 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		Slider aSlider = new Slider(initialBoard);

		SliderAStar aStar = new SliderAStar(aSlider);

		ArrayList<Direction> moves = aStar.solve();

		System.out.println("---");
		System.out.println("876543210");
		System.out.println("---");
		for (Direction aMove : moves) {
			System.out.println(aMove);
		}

		System.out.println("Solved in # moves: " + moves.size());
	}

}
