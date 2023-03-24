package etraveli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class MazeProblemTest {
	
	static char maze [][] = null;
	
	@BeforeClass
	public static void setUp() throws IOException {
		//File file = new File("src/test/java");
		File file = FileUtils.getFile("src", "test", "resources", "maze.txt");
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String st;
		
		int x=0;
		while ((st = bufferedReader.readLine()) !=null) {
			char [] row = st.toCharArray();
			if(null == maze) {
				maze = new char [row.length][row.length];
			}
			for (int i = 0; i < row.length; i++) {
				maze[x][i] = row[i];
			}
			x++;
		}
		/*
		 * for (int i = 0; i < maze.length; i++) { for (int j = 0; j < maze.length; j++)
		 * { System.out.print(maze[i][j]); } System.out.println(); }
		 */
		
	}
	
	@Test
	public void solveMazePrroblem_correctvalue() {
		MazeProblem mazeProblem = new MazeProblem();
		boolean mazeProb = mazeProblem.solveMaze(maze);
		Assert.assertTrue(mazeProb);
	}
	
	
}
