# Etraveli

In this example, the maze array represents the maze, where 'X' represents a wall and '_' represents an open cell. 
The (sx,sy) startRow and startCol variables represent the starting position in the maze, and the (dx,dy) endRow and endCol variables represent the end position.
The solveMaze() method calls a helper method solveMazeProblem() to recursively try to solve the maze from the current cell. The solveMazeProblem method 
checks if the current cell is out of bounds or a wall, and returns false if it is. 
If the current cell is the end position, the method returns true to indicate that the maze has been solved.
Otherwise, the method marks the current cell as visited and recursively tries to solve the maze from all neighboring cells.
If the maze is solved from any of the neighboring cells, the current cell is marked as part of the solution.

In the main() method, a simple maze is created and solved using the MazeProblem class. If the solveMaze() method returns true, the maze provide shortest path to reach desination.

Also MazeProblemTest.java will solve the Maze problem using Maze.txt file.

######################################################



# Command line to run this main class.

Press Enter to execute the command. The Java Virtual Machine (JVM) will start and run your Java application.

This JAR file does not have a Manifest file specifying the main class to run, you can use the following command instead:

java -cp etraveli.jar MazeProblem

#################################################################################

To run the test case from file maze.txt import this project in editor and run MazeProblemTest.java as Junit.
