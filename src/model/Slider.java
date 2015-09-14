package model;

import java.util.ArrayList;
import java.util.Arrays;

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
	private int manhattan = 0;

	/**
	 * A constant representing a perfectly solved slider.
	 */
	public static final int[] SOLVED = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };

	/**
	 * Constructor of object.
	 */
	public Slider() {
		this.board = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
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
	}

	/**
	 * @param count
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
	 *            The position to be swapped with the blank space.
	 */
	private Slider(Slider toCopy, int tileLocation) {
		this.board = toCopy.board;

		this.board[8] = this.board[tileLocation];
		this.board[tileLocation] = 0;
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
	 * The distance between two points.
	 *
	 * @param positionA
	 *            The first position.
	 * @param positionB
	 *            The second position.
	 * @return The distance between.
	 */
	public int distance(int positionA, int positionB) {
		return (this.manhattan() - positionA) - (this.manhattan() - positionB);
	}

	/**
	 * returns the position of the specific tile.
	 *
	 * @param tile
	 *            The tile in question
	 * @return Its position.
	 */
	public int getPosition(int tile) {
		int foundIndex = -1;

		for (int i = 0; i < this.board.length; i++) {
			if (this.board[i] == tile) {
				foundIndex = i;
			}
		}

		if (foundIndex == -1) {
			throw new IllegalStateException("The board does not contain that tile.");
		}

		return foundIndex;

	}

	/**
	 * Moves slider piece down.
	 *
	 * @return A new slider with the down achieved.
	 */
	public Slider down() {

		if (this.canMoveDown()) {

			Slider newSlider = new Slider(new Slider(this.board), this.getPosition(0));
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

			Slider newSlider = new Slider(new Slider(this.board), this.getPosition(0));
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

			Slider newSlider = new Slider(new Slider(this.board), this.getPosition(0));
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

			Slider newSlider = new Slider(new Slider(this.board), this.getPosition(0));
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

		if (aMove == Direction.DOWN) {
			return this.down();
		} else if (aMove == Direction.UP) {
			return this.up();
		} else if (aMove == Direction.LEFT) {
			return this.left();
		} else if (aMove == Direction.RIGHT) {
			return this.right();
		} else {
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
	 * The current state of the slider.
	 *
	 * @return A string representation of the current slider state.
	 */
	public String toString() {
		return Arrays.toString(this.board);
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
	 * Gets the total Manhattan distance for the current state.
	 *
	 * @return The number of Manhattan state.
	 */
	private int manhattan() {
		return 0;
	}

	@Override
	public int hashCode() {

		int hash = 0;
		int multiplier = 10;

		for (int i = 0; i < this.board.length; i++) {
			hash += i * multiplier + this.board[0];
		}
		return hash;
	}
}