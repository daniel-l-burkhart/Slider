package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class SliderAStar {

	private Slider initial;

	public SliderAStar(Slider initial) {

		if (initial == null) {
			throw new IllegalArgumentException("Initial is null.");
		}

		this.initial = initial;
	}

	public ArrayList<Direction> solve() {
		PriorityQueue<Slider> queue = new PriorityQueue<Slider>(11, new SliderComparator());
		HashMap<Slider, Slider> previousPuzzle = new HashMap<>();
		HashMap<Slider, Direction> previousDirection = new HashMap<>();
		HashSet<Slider> closed = new HashSet<>();


		return new ArrayList<>();
	}

	private ArrayList<Direction> buildPath(Slider aSlider, HashMap<Slider, Slider> previousPuzzle,
			HashMap<Slider, Direction> previousDirection) {
		ArrayList<Direction> moves = new ArrayList<>();

		return moves;
	}
}