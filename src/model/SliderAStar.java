package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * The search algorithm for the slider.
 *
 * @author dburkha1
 * @version Fall 2015.
 *
 */
public class SliderAStar {

	private Slider initial;

	/**
	 * The constructor of the a star algorithm.
	 *
	 * @param initial
	 *            The initial slider.
	 */
	public SliderAStar(Slider initial) {

		if (initial == null) {
			throw new IllegalArgumentException("Initial is null.");
		}

		this.initial = initial;
	}

	/**
	 * The solve method of the algorihm.
	 *
	 * @return An arraylist with the solution.
	 */
	public ArrayList<Direction> solve() {
		PriorityQueue<Slider> queue = new PriorityQueue<Slider>(11, new SliderComparator());
		HashMap<Slider, Slider> previousPuzzle = new HashMap<>();
		HashMap<Slider, Direction> previousDirection = new HashMap<>();
		HashSet<Slider> closed = new HashSet<>();

		queue.add(this.initial);

		while ((!queue.isEmpty())) {

			Slider current = queue.peek();

			if (current.solved()) {
				return this.buildPath(current, previousPuzzle, previousDirection);
			}

			closed.add(current);
			for (Direction currentMove : current.getMoves()) {
				if (closed.contains(current.move(currentMove))) {
					continue;
				}

			}

		}

		return this.buildPath(queue.peek(), previousPuzzle, previousDirection);
	}

	private ArrayList<Direction> buildPath(Slider aSlider, HashMap<Slider, Slider> previousPuzzle,
			HashMap<Slider, Direction> previousDirection) {
		ArrayList<Direction> moves = new ArrayList<>();

		return moves;
	}
}