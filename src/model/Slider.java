package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Slider class.
 *
 * @author dburkha1
 * @version Fall 2015
 */
public class Slider {

	private int[] board;
	private int moveCount;

	private final int width = 3;
	private final int rightOrLeft = 1;

	private int manhattanDistance;

	/**
	 * A constant representing a perfectly solved slider.
	 */
	public static final int[] SOLVED = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };

	/**
	 * Constructor of object.
	 */
	public Slider() {
		this.board = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
		this.moveCount = 0;
	}

	/**
	 * Constructor starting with a specific board.
	 *
	 * @param initialBoard
	 *            The initial state of the board.
	 */
	public Slider(int[] initialBoard) {
		if (initialBoard.length == 9) {
			this.board = initialBoard;
		}

		for (int count = 0; count < this.board.length - 1; count++) {
			this.checkForDuplicates(count);
		}

		this.moveCount = 0;
	}

	/**
	 * Checks to make sure there are no duplicates in the slider.
	 *
	 * @param count
	 *            The current count of iteration of the public method.
	 */
	private void checkForDuplicates(int count) {
		for (int i = count + 1; i < this.board.length; i++) {
			if ((this.board[count] == this.board[i]) && (count != i)) {
				throw new IllegalArgumentException("Element is found twice in board.");
			}
		}
	}

	/**
	 * Constructor that creates a board based on an existing board, but the new
	 * board's blank space is swapped with the tile specified by tileLocation.
	 *
	 * @param toCopy
	 *            The existing board.
	 * @param tileLocation
	 *            The position to be swapped with the blank space. 5
	 */
	private Slider(Slider toCopy, int tileLocation) {

		this.board = new int[this.width * this.width];

		for (int i = 0; i < this.board.length; i++) {
			this.board[i] = toCopy.board[i];
		}

		int blankLocation = this.getPosition(0);
		int tempTile = this.board[blankLocation];

		this.board[blankLocation] = this.board[tileLocation];
		this.board[tileLocation] = tempTile;

		this.moveCount = (toCopy.moveCount + 1);
	}

	/**
	 * Clears the moves.
	 */
	public void clearMoves() {
		this.moveCount = 0;
	}

	/**
	 * returns true if solved and false if not.
	 *
	 * @return true if solved, false otherwise.
	 */
	public boolean solved() {

		if (Arrays.equals(this.board, Slider.SOLVED)) {
			return true;
		}

		return false;
	}

	/**
	 * Returns the largest tile supported by this board, which should be 8. This
	 * can be calculated with this.WIDTH * this.WIDTH - 1
	 *
	 * @return the largest tile supported by this board
	 */
	public int largestTile() {
		return (this.width * this.width - 1);
	}

	/**
	 * returns the position of the specific tile.
	 *
	 * @precondition: the tile exists in the board (>-0 and <=8)
	 * @param tile
	 *            The tile in question
	 * @return Its position.
	 */
	public int getPosition(int tile) {

		if (tile < 0 || tile > 8) {
			throw new IllegalArgumentException("Tile not found in this puzzle.");
		}

		int position = -1;

		for (int i = 0; i < 9; i++) {
			if (this.board[i] == tile) {
				position = i;
			}
		}

		if (position == -1) {
			throw new IllegalStateException("The tile is missing when it should not be missing.");
		}

		return position;
	}

	/**
	 * Moves slider piece down.
	 *
	 * @return A new slider with the down achieved.
	 */
	public Slider down() {

		if (this.canMoveDown()) {

			Slider newSlider = new Slider(this, (this.getPosition(0) + this.width));
			this.moveCount += 1;
			return newSlider;

		} else {
			throw new IllegalStateException("Board cannot move down.");
		}
	}

	/**
	 * Moves slider piece up.
	 *
	 * @return A new slider with the up achieved.
	 */
	public Slider up() {

		if (this.canMoveUp()) {

			Slider newSlider = new Slider(this, (this.getPosition(0) - this.width));

			this.moveCount += 1;
			return newSlider;

		} else {
			throw new IllegalStateException("Board cannot move up.");
		}
	}

	/**
	 * Moves slider right.
	 *
	 * @return A new slider with the right achieved.
	 */
	public Slider right() {

		if (this.canMoveRight()) {

			Slider newSlider = new Slider(this, (this.getPosition(0) + this.rightOrLeft));

			this.moveCount += 1;
			return newSlider;

		} else {
			throw new IllegalStateException("Board cannot move right.");
		}
	}

	/**
	 * Moves slider left.
	 *
	 * @return A new slider with the left achieved.
	 */
	public Slider left() {

		if (this.canMoveLeft()) {

			Slider newSlider = new Slider(this, (this.getPosition(0) - this.rightOrLeft));

			this.moveCount += 1;
			return newSlider;

		} else {
			throw new IllegalStateException("Board cannot move left.");
		}
	}

	/**
	 * Moves slider.
	 *
	 * @param aMove
	 *            The current direction you want to move.
	 * @return A new slider with the move achieved.
	 */
	public Slider move(Direction aMove) {

		switch (aMove) {

			case DOWN:
				return this.down();

			case UP:
				return this.up();

			case LEFT:
				return this.left();

			case RIGHT:
				return this.right();

			default:
				throw new IllegalArgumentException("Cannot move no direction.");
		}

	}

	/**
	 * gets the number of moves.
	 *
	 * @return An araylist of the number of moves.
	 */
	public ArrayList<Direction> getMoves() {

		ArrayList<Direction> moves = new ArrayList<>();

		if (this.canMoveDown()) {
			moves.add(Direction.DOWN);
		}

		if (this.canMoveUp()) {
			moves.add(Direction.UP);
		}

		if (this.canMoveRight()) {
			moves.add(Direction.RIGHT);
		}

		if (this.canMoveLeft()) {
			moves.add(Direction.LEFT);
		}

		return moves;
	}

	/**
	 * If the slider can move in that direction
	 *
	 * @return True if the slider can move, false otherwise.
	 */
	public boolean canMoveDown() {

		if ((this.getPosition(0) / this.width) == 2) {
			return false;
		}

		return true;
	}

	/**
	 * If the slider can move in that direction
	 *
	 * @return True if the slider can move, false otherwise.
	 */
	public boolean canMoveUp() {

		if ((this.getPosition(0) / this.width) == 0) {
			return false;
		}

		return true;
	}

	/**
	 * If the slider can move in that direction
	 *
	 * @return True if the slider can move, false otherwise.
	 */
	public boolean canMoveLeft() {

		if ((this.getPosition(0) % this.width) == 0) {
			return false;
		}

		return true;
	}

	/**
	 * If the slider can move in that direction
	 *
	 * @return True if the slider can move, false otherwise.
	 */
	public boolean canMoveRight() {
		if ((this.getPosition(0) % this.width) == 2) {
			return false;
		}

		return true;
	}

	/**
	 * The number of moves.
	 *
	 * @return The number of moves.
	 */
	public int moveCount() {
		return this.moveCount;
	}

	/**
	 * The score of the game.
	 *
	 * @return The score
	 */
	public int score() {
		return this.manhattan() + this.moveCount;
	}

	/**
	 * The distance between two points.
	 *
	 * @param positionA
	 *            The first position.
	 * @param positionB
	 *            The second position.
	 * @return The distance between.
	 */
	public int distance(int positionA, int positionB) {
		return Math.abs((positionA / this.width) - (positionB / this.width))
				+ Math.abs((positionA % this.width) - positionB % this.width);
	}

	/**
	 * Gets the total Manhattan distance for the current state.
	 *
	 * @return The number of Manhattan state.
	 */
	private int manhattan() {

		this.manhattanDistance = 0;

		for (int i = 0; i < this.board.length; i++) {
			for (int current = 0; current < this.board.length; current++) {
				if (this.board[i] == Slider.SOLVED[current])
					this.manhattanDistance += this.distance(i, current);
			}
		}

		return this.manhattanDistance;

	}

	/**
	 * returns a string representation of the current state.
	 *
	 * @return A string of the board.
	 */
	public String toString() {

		String puzzleShape = "[ ";

		for (int i = 0; i < this.board.length; i++) {
			if (i > 0 && i % this.width == 0) {
				puzzleShape += "]\n[ ";
			}

			puzzleShape += String.format("%2d ", this.board[i]);
		}
		puzzleShape += "]\n";
		return puzzleShape;
	}

	@Override
	public boolean equals(Object currentObject) {

		if (currentObject == null) {
			return false;
		}

		if (currentObject == this) {
			return true;
		}

		if (this.getClass() != currentObject.getClass()) {
			return false;
		}

		return this.hashCode() == currentObject.hashCode();
	}

	@Override
	public int hashCode() {

		int hash = 0;
		int multiplier = 1;

		for (int i = 0; i < this.board.length; i++) {
			hash += multiplier * this.board[i];
			multiplier *= 10;
		}

		return hash;
	}
}