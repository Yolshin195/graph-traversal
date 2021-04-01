package ru.yolshin.graph;

import java.util.*;

/**
 * Graph
 */
public class Graph {
    public final Map<String, Vertex> vertices;

    /**
     * @param vertices множество вершин графа
     * @param edges множество ребер графа(Матрица смежности)
     */
    public Graph(String[] vertices, int[][] edges) {
        this.vertices = new HashMap<>();
        for (int i = 0; i < vertices.length; i++) {
            var es = new ArrayList<String>();
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] == 1) {
                    es.add(vertices[j]);
                }
            }
            this.vertices.put(vertices[i], new Vertex(vertices[i], es));
        }
    }

    /**
     * Depth-first search
     * Алгоритм:
     *   1. Кладём на стек первую вершину.
     *   2. Пока стек не пуст, извлекаем верхнюю вершину. Если она бела
     *     2.1 Красим в чёрный цвет.
     *     2.2 Кладём в стек всех её белых соседок в порядке, обратном порядку обхода.
     *
     * @param a Начало обхода графа
     * @return Все посещенные вершины
     */
    public List<String> dfs(String a) {
        var visited = new ArrayList<String>();
        var stack = new Stack<Vertex>();
        stack.push(vertices.get(a));
        visited.add(a);

        while (!stack.isEmpty()) {
            var v = stack.pop();
            for (var e : v.edges) {
                if (!visited.contains(e)) {
                    stack.push(vertices.get(e));
                    visited.add(e);
                }
            }
        }

        return visited;
    }

    /**
     * Breadth-first search
     * Алгоритм:
     *   1. Поместить узел, с которого начинается поиск, в изначально пустую очередь.
     *   2. Извлечь из начала очереди узел u и пометить его как развёрнутый.
     *     2.1 Если узел u является целевым узлом, то завершить поиск с результатом «успех».
     *     2.2 В противном случае, в конец очереди добавляются все преемники узла u, которые ещё не развёрнуты и не находятся в очереди.
     *   3.Если очередь пуста, то все узлы связного графа были просмотрены, следовательно, целевой узел недостижим из начального; завершить поиск с результатом «неудача».
     *   4.Вернуться к п. 2.
     * @param a Начало обхода графа
     * @return Все посещенные вершины
     */
    public List<String> bfs(String a) {
        List<String> visited = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(vertices.get(a));
        visited.add(a);

        while (!queue.isEmpty()) {
            var v = queue.poll();

            for (var e : v.edges) {
                if (!visited.contains(e)) {
                    queue.offer(vertices.get(e));
                    visited.add(e);
                }
            }
        }

        return visited;
    }

    /**
     * @param name Вершина
     * @param edges Ребра связанные с вершиной
     */
    public record Vertex(String name, List<String> edges) { }
}
