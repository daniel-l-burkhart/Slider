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

			Slider aSlider = queue.poll();

			if (aSlider.solved()) {
				return this.buildPath(aSlider, previousPuzzle, previousDirection);
			}

			closed.add(aSlider);
			ArrayList<Direction> directions = aSlider.getMoves();

			for (Direction aDirection : directions) {
				Slider aBranch = aSlider.move(aDirection);
				if (!closed.contains(aBranch)) {
					previousPuzzle.put(aBranch, aSlider);
					previousDirection.put(aBranch, aDirection);
					queue.add(aBranch);
				}

			}

		}

		return null;
	}

	/**
	 * Method that builds the path of the solution.
	 * 
	 * @param aSlider
	 *            The current slider.
	 * @param previousPuzzle
	 *            The previous Slider.
	 * @param previousDirection
	 *            The previous Direction.
	 * @return An ArrayList of the path's solution.
	 */
	private ArrayList<Direction> buildPath(Slider aSlider, HashMap<Slider, Slider> previousPuzzle,
			HashMap<Slider, Direction> previousDirection) {
		ArrayList<Direction> moves = new ArrayList<>();

		while (previousPuzzle.containsKey(aSlider)) {
			moves.add(0, previousDirection.get(aSlider));
			aSlider = previousPuzzle.get(aSlider);
		}
		return moves;
	}
}