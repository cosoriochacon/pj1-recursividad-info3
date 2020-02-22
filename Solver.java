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
        arg = test3(0, maze.getStartSpace(), maze, arg, "");
        // method 1:
        String values = Arrays.toString(arg.toArray());
        // System.out.println("-----------------------------------------------------");
        // System.out.println(values);
        values = values.substring(1);
        values = values.substring(0, values.length() - 1);
        // System.out.println(values);
        // values.replaceAll(",_", ", ");
        str = values.split(", ");
        String[] res = new String[str.length];
        int cont = 0;
        for (String value : str) { 
            res[cont] = value.replace(",_", ", ");
            cont++;
        }
        // System.out.println("-----------------------------------------------------");
        // System.out.println("WIDTH: " + maze.getWidth());
        // System.out.println("HEIGTH:" + maze.getHeight());
        // System.out.println("EXITSPACE:" + maze.getExitSpace());
        // System.out.println("STARTSPACE:" + maze.getStartSpace());
        // System.out.println("MAXMOVES:" + maze.getMaxMoves());
        // System.out.println("NORTE:" + maze.moveNorth(maze.getStartSpace()));
        // System.out.println("SUR:" + maze.moveEast(maze.getStartSpace()));
        // System.out.println("ESTE:" + maze.moveSouth(maze.getStartSpace()));
        // System.out.println("OESTE:" + maze.moveWest(maze.getStartSpace()));

        return res;
    }

    public Stack<String> test3(int currentMoves, int section, Maze maze, Stack<String> arg, String currentPath) {
        // currentMoves = 0;

        // System.out.println("Empece iteracion: " + currentMoves + section + arg + currentPath);

        if (section == maze.getExitSpace()) {
            currentPath += section + "]";
            // System.out.println(currentPath);
            // System.out.println(":)");
            arg.push(currentPath);
            // System.out.println("Finalice");
            return arg;
        }

        if (currentMoves >= maze.getMaxMoves())
            return arg;
        
        if (maze.moveNorth(section) != section) {
            
            
            // System.out.println("Voy al norte: " + currentMoves + section + arg + currentPath);
            arg = test3(currentMoves + 1, maze.moveNorth(section), maze, arg, concatenerPath(currentPath, section));
        }

        if (maze.moveSouth(section) != section) {
            
            // System.out.println("Voy al sur: " + currentMoves + section + arg + currentPath);
            arg = test3(currentMoves + 1, maze.moveSouth(section), maze, arg, concatenerPath(currentPath, section));
        }

        if (maze.moveEast(section) != section) {
            
            // System.out.println("Voy al Este: " + currentMoves + section + arg + currentPath);
            arg = test3(currentMoves + 1, maze.moveEast(section), maze, arg, concatenerPath(currentPath, section));
        }

        if (maze.moveWest(section) != section) {
            
            // System.out.println("Voy al Oeste: " + currentMoves + section + arg + currentPath);
            arg = test3(currentMoves + 1, maze.moveWest(section), maze, arg, concatenerPath(currentPath, section));
        }

        // System.out.println("Termine iteracion: " + currentMoves + section + arg + currentPath);
        return arg;

    }

    public String concatenerPath(String path, int text) {
        if (path.length() == 0) {
            return path += "[" + text + ",_";
        } else {
            return path += text + ",_";
        }

    }

}