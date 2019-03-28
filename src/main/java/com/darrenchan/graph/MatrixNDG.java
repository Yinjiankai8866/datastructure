package com.darrenchan.graph;

import java.util.LinkedList;

public class MatrixNDG {
    int size;//图顶点个数
    char[] vertexs;//图顶点名称
    int[][] matrix;//图关系矩阵

    public MatrixNDG(char[] vertexs, char[][] edges){
        size=vertexs.length;
        matrix=new int[size][size];//设定图关系矩阵大小
        this.vertexs=vertexs;

        for(char[] c:edges){//设置矩阵值
            int p1 = getPosition(c[0]);//根据顶点名称确定对应矩阵下标
            int p2 = getPosition(c[1]);

            matrix[p1][p2] = 1;//无向图，在两个对称位置存储
            matrix[p2][p1] = 1;
        }
    }

    //图的遍历输出
    public void print(){
        for(int[] i:matrix){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    //根据顶点名称获取对应的矩阵下标
    private int getPosition(char ch) {
        for(int i=0; i<vertexs.length; i++)
            if(vertexs[i]==ch)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'D', 'G'},
                {'I', 'J'},
                {'J', 'G'},
                {'E', 'H'},
                {'H', 'K'}};
        MatrixNDG pG = new MatrixNDG(vexs, edges);
        pG.print();

        pG.DFS();
        System.out.println();
        pG.BFS();
    }

    public void DFS(){
        boolean[] beTraversed = new boolean[size];
        System.out.print(vertexs[0] + " ");
        beTraversed[0] = true;
        DFS(0, 0, beTraversed);
    }

    private void DFS(int x, int y, boolean[] beTraversed){
        while(y <= size - 1){
            if(matrix[x][y] != 0 && beTraversed[y] == false){
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;
                DFS(y, 0, beTraversed);
            }
            y++;
        }
    }

    public void BFS(){
        boolean[] beTraversed = new boolean[size];
        System.out.print(vertexs[0] + " ");
        beTraversed[0] = true;
        BFS(0, beTraversed);
    }

    private void BFS(int x, boolean[] beTraversed){
        LinkedList<Character> list = new LinkedList<>();
        int y = 0;
        while(y <= size - 1){
            if(matrix[x][y] != 0 && beTraversed[y] == false){
                System.out.print(vertexs[y] + " ");
                beTraversed[y] = true;
                list.add(vertexs[y]);
            }
            y++;
        }

        while(!list.isEmpty()){
            char ch = list.pop();
            int t = getPosition(ch);
            BFS(t, beTraversed);
        }
    }

}
