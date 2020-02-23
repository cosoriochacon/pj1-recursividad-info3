/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/

import java.util.*;

public class Solver {

    public Solver() {

        // Sientase libre de implementar el contructor de la forma que usted lo desee
    }

    public String[] solve(Maze maze) {
        Stack<String> arg = new Stack<String>();
        // Implemente su metodo aqui. Sientase libre de implementar métodos adicionales
        String[] str = new String[1];
        str[0] = "[-1]";
        arg = searchRoutes(0, maze.getStartSpace(), maze, arg, "");
        // method 1:
        String values = Arrays.toString(arg.toArray());
        values = values.substring(1);
        values = values.substring(0, values.length() - 1);
        str = values.split(", ");
        String[] res = new String[str.length];
        int cont = 0;
        for (String value : str) {
            res[cont] = value.replace(",_", ", ");
            cont++;
        }

        return res;
    }

    public Stack<String> searchRoutes(int currentMoves, int section, Maze maze, Stack<String> arg, String currentPath) {

        if (section == maze.getExitSpace()) {
            currentPath += section + "]";
            arg.push(currentPath);
            return arg;
        }

        if (currentMoves >= maze.getMaxMoves())
            return arg;

        if (maze.moveNorth(section) != section) {
            arg = searchRoutes(currentMoves + 1, maze.moveNorth(section), maze, arg, concatenarPath(currentPath, section));
        }

        if (maze.moveSouth(section) != section) {
            arg = searchRoutes(currentMoves + 1, maze.moveSouth(section), maze, arg, concatenarPath(currentPath, section));
        }

        if (maze.moveEast(section) != section) {
            arg = searchRoutes(currentMoves + 1, maze.moveEast(section), maze, arg, concatenarPath(currentPath, section));
        }

        if (maze.moveWest(section) != section) {
            arg = searchRoutes(currentMoves + 1, maze.moveWest(section), maze, arg, concatenarPath(currentPath, section));
        }
        return arg;

    }

    public String concatenarPath(String path, int text) {
        if (path.length() == 0) {
            return path += "[" + text + ",_";
        } else {
            return path += text + ",_";
        }

    }

}