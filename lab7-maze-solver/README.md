Project 1: Recursive Maze Solver

In this lab, you will implement a recursive algorithm to find a path through a maze. This technique is known as "backtracking" and is a classic application of recursion.

Background

Imagine a maze represented by a 2D grid. Some cells are open paths (' '), some are walls ('#'), one is the start ('S'), and one is the finish ('F'). Your goal is to write a method that recursively explores the maze to find a path from 'S' to 'F'.

The core idea is a recursive method, perhaps called solve(row, col), that returns true if a path is found from the given (row, col) to the finish, and false otherwise.

The Recursive Logic

Base Cases (Stopping Conditions):
If the current cell (row, col) is outside the maze boundaries, it's not a valid path. Return false.
If the current cell is a wall ('#') or has already been visited, it's not a valid path. Return false.
If the current cell is the finish ('F'), you've found a solution! Return true.

Recursive Step:
Mark the current cell as part of the path (e.g., with a '.') to avoid cycles.
Recursively try to solve from the cell to the North, then East, then South, then West. If any of these calls return true, you have found a path, so return true immediately.
If none of the recursive calls find a path, this cell must be a dead end. Backtrack by un-marking the cell (change it back from '.' to ' ') and return false. This is a crucial step!
Your Task

Create a MazeSolver.java class.
Implement the recursive solve() method.
Include a main method that initializes a maze, creates a solver, attempts to solve it, and prints the final maze.
Test your solver on at least two mazes: one with a solution and one without.

Code Template

public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the current state of the maze.
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    /**
     * Public wrapper method to start the maze-solving process.
     * It should find the starting 'S' position and initiate the recursive search.
     * @return true if a path is found, false otherwise.
     */
    public boolean solve() {
        // TODO: Find the starting row and column of 'S'
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }

    /**
     * The core recursive method to solve the maze.
     * @param row The current row position.
     * @param col The current column position.
     * @return true if this position leads to a solution, false otherwise.
     */
    private boolean solve(int row, int col) {
        // TODO: Implement the recursive logic with backtracking here.

        // 1. Base Case (Stopping Conditions)
        // Check if out of bounds, a wall, or already visited.
        // Check if the current cell is the finish ('F').

        // 2. Recursive Step
        // Mark the current cell as part of the path.
        // Try moving North, East, South, West.
        // If any direction returns true, then you've found a path, return true.

        // 3. Backtracking
        // If no direction works, un-mark the cell and return false.

        return false; // Placeholder
    }

    public static void main(String[] args) {
        char[][] mazeToSolve = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver = new MazeSolver(mazeToSolve);

        System.out.println("Original Maze:");
        solver.printMaze();

        if (solver.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver.printMaze();
    }
}
