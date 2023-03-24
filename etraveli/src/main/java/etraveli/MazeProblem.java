package etraveli;

import java.util.Collections;
import java.util.Stack;

/**
 * @author ashish.ranjan1@gmail.com
 *
 */
public class MazeProblem {

	public static final char UNDER_SCORE = '_';
	public static final char START = 'S';
	public static final char DESTINATION = 'G';
	public static final char BLOCK = 'X';

	// Size of maze
	static int N;
	static boolean reverse = false;
	static Stack<String> stack = new Stack<String>();

	/**
	 * This method print solution matxix sol[N][N]
	 * 
	 * @param sol
	 */
	void printSolution(char sol[][]) {
		/*
		 * for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) {
		 * System.out.print(" " + sol[i][j] + " "); }
		 * 
		 * System.out.println(); }
		 */
		if (reverse)
			Collections.reverse(stack);
		System.out.println(stack);
	}

	/**
	 * this method check if x, y is valid for N+N maze
	 * 
	 * @param maze
	 * @param x
	 * @param y
	 * @return
	 */
	boolean isSafe(char maze[][], int x, int y) {
		// if(x, y outside maze ) return false

		return (x >= 0 && x < N && y >= 0 
				&& y < N && (maze[x][y] == UNDER_SCORE || maze[x][y] == START || maze[x][y] == DESTINATION));
	}

	/**
	 * This method solve the Maze problem using backtracking using recursion. it
	 * return false if no path is possible otherwise return true and print the path.
	 * 
	 * @param maze
	 * @return
	 */
	boolean solveMaze(char maze[][]) {
		N = maze.length;
		char sol[][] = new char[N][N];
		int dx = -1;
		int dy = -1;
		int sx = -1;
		int sy = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (maze[i][j] == DESTINATION) {
					dx = i;
					dy = j;
					break;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (maze[i][j] == START) {
					sx = i;
					sy = j;
					break;
				}
			}

		}
		if ((sx > dx) || (sx == dx && sy > dy)) {
			reverse = true;
			maze[sx][sy] = START;
			maze[dx][dy] = DESTINATION;
			int temp = sx;
			sx = dx;
			dx = temp;
			temp = sy;
			sy = dy;
			dy = temp;
		}

		if (sx == -1 || sy == -1 || dx == -1 || dy == -1) {
			System.out.println("Path doesn't exist.");
			return false;
		}

		if (solveMazeProblem(maze, sx, sy, dx, dy, sol) == false) {
			System.out.println("Path doesn't exist.");
			return false;
		}
		printSolution(sol);
		return true;
	}

	/**
	 * A recursive utility to solve Maze problem
	 * 
	 * @param maze
	 * @param s1
	 * @param s2
	 * @param d1
	 * @param d2
	 * @param sol
	 * @return
	 */
	boolean solveMazeProblem(char[][] maze, int s1, int s2, int d1, int d2, char[][] sol) {
		if (s1 == d1 && s2 == d2 
				&& maze[s1][s2] == START) {
			stack.add(s1 + "," + s2);
			sol[s1][s2] = UNDER_SCORE;
			return true;
		}
		// check if maze[sx][sy] is valid
		if (isSafe(maze, s1, s2) == true) {

			// mark sx sy as a part of solution path
			if (sol[s1][s2] == UNDER_SCORE) {
				return false;
			}
			
			
			sol[s1][s2] = UNDER_SCORE;
			stack.add(s1 + "," + s2);
			// Move forward in X direction
			if (solveMazeProblem(maze, s1 + 1, s2, d1, d2, sol)) 
				return true;
			
			// if moving in x direction doesn't give solution then
			// Move down in y direction
			if (solveMazeProblem(maze, s1, s2 + 1, d1, d2, sol)) 
				return true;
			
			// Move backward in X direction

			if (solveMazeProblem(maze, s1 - 1, s2, d1, d2, sol))
				return true;
			
			// if moving ack in x direction doesn't give solution then
			// Move up in y direction

			if (solveMazeProblem(maze, s1, s2 - 1, d1, d2, sol)) 
				return true;
			

			// if none of the solution get worked then backtrack.
			// unmark sx and sy to BLOCK in path

			sol[s1][s2] = BLOCK;
			stack.pop();
			return false;
		}
		return false;
	}

	public static void main(String args[]) {
		MazeProblem mazeProblem = new MazeProblem();

		char maze[][] = { { UNDER_SCORE, UNDER_SCORE, UNDER_SCORE, DESTINATION, UNDER_SCORE, BLOCK },
				{ UNDER_SCORE, UNDER_SCORE, BLOCK, BLOCK, BLOCK, UNDER_SCORE },
				{ BLOCK, UNDER_SCORE, UNDER_SCORE, UNDER_SCORE, UNDER_SCORE, BLOCK },
				{ BLOCK, UNDER_SCORE, UNDER_SCORE, UNDER_SCORE, UNDER_SCORE, BLOCK },
				{ UNDER_SCORE, UNDER_SCORE, BLOCK, UNDER_SCORE, UNDER_SCORE, UNDER_SCORE },
				{ UNDER_SCORE, BLOCK, START, UNDER_SCORE, BLOCK, BLOCK } };
		N = maze.length;
		mazeProblem.solveMaze(maze);
	}
}
