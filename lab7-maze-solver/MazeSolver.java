public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    /**
     * Prints the current state of the maze.
     */
    public void printMaze() {
//        System.out.println("maze.length = " + maze.length);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
//                System.out.println("maze["+i+"].length = " + maze[i].length);
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
                    System.out.println("Start = ["+startRow+"]["+startCol+"]");
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
        System.out.println("Trying (" + row + ", " + col + ")");
        // TODO: Implement the recursive logic with backtracking here.

        // 1. Base Case (Stopping Conditions)
        // Check if out of bounds
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[row].length){
            System.out.println("Out of bounds at (" + row + ", " + col + ")");
            return false;
        }
        // Check if a wall '#'
        if (maze[row][col] == '#'){
            System.out.println("Hit wall at (" + row + ", " + col + ")");
            return false;
        }
        // Check if already visited '.'
        if ( maze[row][col] == '.'){
            System.out.println("Already visited at (" + row + ", " + col + ")");
            return false;
        }

        // Check if the current cell is the finish ('F').
        if (maze[row][col] == 'F'){
            System.out.println("Finish point (F):  (" + row + ", " + col + ")");
            return true;
        }

        // Check if the current cell is the start ('S').
        if (maze[row][col] == 'S'){
            System.out.println("Starting point (S):   (" + row + ", " + col + ")");
        }

        // 2. Recursive Step
        // Mark the current cell as part of the path.
        if (maze[row][col] != 'S'){
            maze[row][col] = '.';           // mark '.' as visited
            System.out.println("Marking (" + row + ", " + col + ")");
            printMaze();
        }
        // Try moving North, East, South, West.
        // If any direction returns true, then you've found a path, return true.
        // North: maze[row-1][col]
        if (solve(row-1,col )){
            return true;
        }
        // East: maze[row][col+1]
        if (solve(row,col+1 )){
            return true;
        }
        // South: maze[row+1][col]
        if (solve(row+1,col )){
            return true;
        }
        // West: maze[row][col-1]
        if (solve(row,col-1 )){
            return true;
        }

        // 3. Backtracking
        // If no direction works, un-mark the cell and return false.
        if (maze[row][col] != 'S'){
            maze[row][col] = ' ';
            System.out.println("Backtracking (" + row + ", " + col + ")");
            printMaze();
        }

        return false; // Placeholder
    }

    public static void main(String[] args) {
        char[][] mazeToSolve = {
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', '#', ' ', ' ', '#'},
                {'#', ' ', ' ', '#', ' ', '#', '#'},
                {'#', '#', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', 'F', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        char[][] mazeToSolve1 = {
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