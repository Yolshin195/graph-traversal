package ru.yolshin.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GraphTests {
    private static final Graph graph = new Graph(
            new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"},
            new int[][]{
//                   A B C D E F G H I J K L
                    {0,1,0,0,1,0,0,0,0,0,0,0}, //A - 0
                    {1,0,1,0,0,1,0,0,0,0,0,0}, //B - 1
                    {0,1,0,1,0,0,1,0,0,0,0,0}, //C - 2
                    {0,0,1,0,0,0,0,1,0,0,0,0}, //D - 3
                    {1,0,0,0,0,1,0,0,1,0,0,0}, //E - 4
                    {0,1,0,0,1,0,1,0,0,1,0,0}, //F - 5
                    {0,0,1,0,0,1,0,1,0,0,1,0}, //G - 6
                    {0,0,0,1,0,0,1,0,0,0,0,1}, //H - 7
                    {0,0,0,0,1,0,0,0,0,1,0,0}, //I - 8
                    {0,0,0,0,0,1,0,0,1,0,1,0}, //J - 9
                    {0,0,0,0,0,0,1,0,0,1,0,1}, //K - 10
                    {0,0,0,0,0,0,0,1,0,0,1,0}, //L - 11
            });

    @Test
    void dfs() {
        System.out.println(graph.dfs("A"));
        assertEquals(graph.dfs("A").size(), 12);
    }

    @Test
    void bfs() {
        System.out.println(graph.bfs("A"));
        assertEquals(graph.bfs("A").size(), 12);
    }
}
