package edu.project2;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.RecursiveTask;
import static edu.project2.Cell.Type.PASSAGE;
import static edu.project2.Cell.Type.WALL;

public class MultiThreadSolver extends RecursiveTask<List<Cell>> implements Solver {
    private static final int[] ROW = {-1, 0, 0, 1};
    private static final int[] COL = {0, -1, 1, 0};
    private static final int FOUR = 4;
    private static Stack<Cell> cellStack;
    Maze maze;
    Cell start;
    Cell end;

    public MultiThreadSolver(Stack<Cell> stack, Maze maze, Cell start, Cell end)
    {
        solve(stack, maze, start, end);
    }

    @Override
    public List<Cell> solve(Maze maze, Cell start, Cell end) {
        this.maze = maze;
        this.end = end;
        this.start = start;
        if (maze.getGrid()[start.getRow()][start.getCol()].type == WALL
            || maze.getGrid()[end.getRow()][end.getCol()].type == WALL) {
            throw new RuntimeException("Точки не могут быть стенами!");
        }
        cellStack = new Stack<>();
        List<Cell> result = new ArrayList<>();

        maze.getGrid()[start.getRow()][start.getCol()].setVisited(true);
        Cell cell = maze.getGrid()[start.getRow()][start.getCol()];
        cellstack.add(cell);
        int count;
        while (!stack.isEmpty()) {
            count = 0;
            if (cell.getRow() == end.getRow() && cell.getCol() == end.getCol()) {
                result.addFirst(stack.pop());
            } else {
                for (int i = 0; i < FOUR; ++i) {
                    int x = cell.getRow() + ROW[i];
                    int y = cell.getCol() + COL[i];
                    if (maze.getGrid()[x][y].type == PASSAGE && !maze.getGrid()[x][y].isVisited()) {
                        ++count;
                        stack.add(maze.getGrid()[x][y]);
                        maze.getGrid()[x][y].setVisited(true);
                        cell = stack.peek();

                    }

                }
                if (count == 0) {
                    stack.pop();
                    cell = stack.peek();
                }
            }
        }
        return result;
    }

    private void actionsForDifferentCountOfDirections(List<Integer> directions, Cell currentCell, List<Cell> path) {
        if (directions.size() <= 1) {
            currentCell.setVisited(true);
        } else {
            MultiThreadSolver multiThreadSolver =
                new MultiThreadSolver(
                    maze,
                    new Cell(currentCell.getRow(), currentCell.getCol()),
                    end
                );
            multiThreadSolver.fork();
            path.addAll(multiThreadSolver.join());
        }
    }

    @Override
    protected List<Cell> compute() {
        return solve(maze, start, end);
    }
}*/
