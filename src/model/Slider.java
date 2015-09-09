package model;

import java.util.ArrayList;

/**
 * Slider class.
 *
 * @author dburkha1
 * @version Fall 2015
 */
public class Slider {
	private int[] board;
	private int moveCount;

	final private int WIDTH = 3;

	/**
	 * Constructor of object.
	 */
	public Slider() {
	}

	/**
	 * Constructor starting with a specific board.
	 *
	 * @param initialBoard
	 *            The initial state of the board.
	 */
	public Slider(int[] initialBoard) {
	}

	private Slider(Slider toCopy, int tileLocation) {
	}

	/**
	 * Clears the moves.
	 */
	public void clearMoves() {
	}

	/**
	 * returns true if solved and false if not.
	 *
	 * @return true if solved, false otherwise.
	 */
	public boolean solved() {
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
		return 0;
	}

	/**
	 * returns the position of the specific tile.
	 *
	 * @param tile
	 *            The tile in question
	 * @return Its position.
	 */
	public int getPosition(int tile) {
		return 0;
	}

	/**
	 * Moves slider piece down.
	 *
	 * @return A new slider with the down achieved.
	 */
	public Slider down() {
		return new Slider();
	}

	/**
	 * Moves slider piece up.
	 *
	 * @return A new slider with the up achieved.
	 */
	public Slider up() {
		return new Slider();
	}

	/**
	 * Moves slider right.
	 *
	 * @return A new slider with the right achieved.
	 */
	public Slider right() {
		return new Slider();
	}

	/**
	 * Moves slider left.
	 *
	 * @return A new slider with the left achieved.
	 */
	public Slider left() {
		return new Slider();
	}

	/**
	 * Moves slider.
	 *
	 * @param aMove
	 *            The current direction you want to move.
	 * @return A new slider with the move achieved.
	 */
	public Slider move(Direction aMove) {
		if (aMove == Direction.NONE) {
			throw new IllegalArgumentException("Cannot move no direction.");
		}

		if (aMove == Direction.DOWN) {
			return this.down();
		}

		if (aMove == Direction.UP) {
			return this.up();
		}

		if (aMove == Direction.LEFT) {
			return this.left();
		}

		if (aMove == Direction.RIGHT) {
			return this.right();
		}

		return null;
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
		return false;
	}

	/**
	 * If the slider can move in that direction
	 *
	 * @return True if the slider can move, false otherwise.
	 */
	public boolean canMoveUp() {
		return false;
	}

	/**
	 * If the slider can move in that direction
	 *
	 * @return True if the slider can move, false otherwise.
	 */
	public boolean canMoveLeft() {
		return false;
	}

	/**
	 * If the slider can move in that direction
	 *
	 * @return True if the slider can move, false otherwise.
	 */
	public boolean canMoveRight() {
		return false;
	}

	/**
	 * The current state of the slider.
	 *
	 * @return A string representation of the current slider state.
	 */
	public String toString() {
		return "";
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