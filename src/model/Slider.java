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

	private final int width = 3;

	/**
	 * Constructor of object.
	 */
	public Slider() {
		this.board = new int[9];

		int count = 1;
		for (int i = 0; i < 8; i++) {
			this.board[i] = count;
			count += 1;
		}

		this.board[8] = 0;

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
	}

	private Slider(Slider toCopy, int tileLocation) {
		this.board = toCopy.board;
		this.board[8] = tileLocation;
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
		int[] solvedBoard = new int[9];
		solvedBoard[0] = 1;
		solvedBoard[1] = 2;
		solvedBoard[2] = 3;
		solvedBoard[3] = 4;
		solvedBoard[4] = 5;
		solvedBoard[5] = 6;
		solvedBoard[6] = 7;
		solvedBoard[7] = 8;
		solvedBoard[8] = 0;

		if (this.board.equals(solvedBoard)) {
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

		if (this.board[0] == tile) {
			return 0;
		} else if (this.board[1] == tile) {
			return 1;
		} else if (this.board[2] == tile) {
			return 2;
		} else if (this.board[3] == tile) {
			return 3;
		} else if (this.board[4] == tile) {
			return 4;
		} else if (this.board[5] == tile) {
			return 5;
		} else if (this.board[6] == tile) {
			return 6;
		} else if (this.board[7] == tile) {
			return 7;
		} else if (this.board[8] == tile) {
			return 8;
		} else {
			throw new IllegalStateException("Tile does not exist in board.");
		}
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