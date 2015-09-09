package model;

import java.util.ArrayList;

public class Slider {
	private int[] board;
	private int moveCount;

	final private int WIDTH = 3;

	public Slider() {
	}

	public Slider(int[] initialBoard) {
	}

	private Slider(Slider toCopy, int tileLocation) {
	}

	public void clearMoves() {
	}

	public boolean solved() {
		return false;
	}

	public int distance(int positionA, int positionB) {
		return 0;
	}

	public int getPosition(int tile) {
		return 0;
	}

	public Slider down() {
		return new Slider();
	}

	public Slider up() {
		return new Slider();
	}

	public Slider right() {
		return new Slider();
	}

	public Slider left() {
		return new Slider();
	}

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

	public boolean canMoveDown() {
		return false;
	}

	public boolean canMoveUp() {
		return false;
	}

	public boolean canMoveLeft() {
		return false;
	}

	public boolean canMoveRight() {
		return false;
	}

	public String toString() {
		return "";
	}

	public int moveCount() {
		return this.moveCount;
	}

	public int score() {
		return manhattan() + this.moveCount;
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