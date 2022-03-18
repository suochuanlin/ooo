package com.myooo.myooo.practice.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DepthFirstTraversal {

    ListGraph graph;
    boolean[] visited;

    public DepthFirstTraversal(ListGraph graph) {
        this.graph = graph;
        visited = new boolean[graph.graphs.size()]; //顶点数量
    }

    public void DFS() {
        System.out.println("DFS-> 深度优先搜索遍历 ");
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]){
                DFSTraversal(i);
            }
        }
    }

    /**
     * 深度遍历
     * 迭代子节点递归
     * 具体实现
     *
     * @param v
     */
    public void DFSTraversal(int v) {
        //递归回退条件
        if (visited[v]) return;
        //具体逻辑
        visited[v] = true;
        System.out.print(v + 1 + "->");
        Iterator<Integer> neighbors = graph.graphs.get(v).iterator();
        while (neighbors.hasNext()) {
            int nextNode = neighbors.next();
            if (!visited[nextNode]) {
                DFSTraversal(nextNode);
            }
        }
    }

    public static void main(String[] args) {
        ListGraph listGraph = new ListGraph(8);
        //添加边 8个顶点下标为 0-7
        //邻接表
        //1->2->3
        listGraph.addEdge(0, 1);
        listGraph.addEdge(0, 2);
        //2->4>5
        listGraph.addEdge(1, 3);
        listGraph.addEdge(1, 4);
        //3->6->7
        listGraph.addEdge(2, 5);
        listGraph.addEdge(2, 6);
        //4->8
        listGraph.addEdge(3, 7);
        //5->8
        listGraph.addEdge(4, 7);
        //6->8
        listGraph.addEdge(5, 7);
        //7->8
        listGraph.addEdge(6, 7);
        //遍历
        DepthFirstTraversal depthFirstTraversal = new DepthFirstTraversal(listGraph);
//        depthFirstTraversal.DFS();
        depthFirstTraversal.BFS();
    }


    public void BFSTraversal(int v) {
        //1、Deque 双端队列
        Deque<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.offerFirst(v);
        while (queue.size() != 0) {
            //pollFirst 删除头部第一个元素
            Integer cur = queue.pollFirst();
            System.out.print(cur + 1 + " -> ");
            Iterator<Integer> neighbors = graph.graphs.get(cur).listIterator();
            while (neighbors.hasNext()) {
                int nextNode = neighbors.next();
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    //offerLast 从尾部插入元素
                    queue.offerLast(nextNode);
                }
            }
        }
    }

    public void BFS() {
        System.out.println("BFS-> 广度优先搜索遍历 ");
        for (int i = 0; i < graph.graphs.size(); i++) {
            if (!visited[i]) {
                BFSTraversal(i);
            }
        }
    }

}
