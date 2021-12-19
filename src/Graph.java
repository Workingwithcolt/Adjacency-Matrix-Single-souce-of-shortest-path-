import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    ArrayList<Graphnode> nodeList;
    int[][] AdjacencyMatrix;
    int p = 0;
    public Graph(ArrayList<Graphnode> nodeList){
        this.nodeList = nodeList;
        AdjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }
    public void addUndirectedEdge(int i,int j){
        AdjacencyMatrix[i][j] = 1;//here we set the Adjacency matrix = 1 that represent the edge when we represent
        //it by one we are creating the egde from the i to j and j to i
        AdjacencyMatrix[j][i] = 1;
    }
    void print(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(AdjacencyMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public ArrayList<Graphnode> getNeighbors(Graphnode node){
        ArrayList<Graphnode> neighbors =new ArrayList<>();
        int nodeIndex = node.index;
        for(int i=0;i<AdjacencyMatrix.length;i++){
            if(AdjacencyMatrix[nodeIndex][i] == 1){
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    void BFSVisit(Graphnode node){
        LinkedList<Graphnode> queue = new LinkedList<Graphnode>();
        queue.add(node);
        while(!queue.isEmpty()){
            Graphnode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.println(currentNode.name+" ");
            ArrayList<Graphnode> neighbors = getNeighbors(currentNode);
            for(Graphnode neighbor: neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }
    public void BFS(){
        for(Graphnode node:nodeList){
            if(!node.isVisited){
                BFSVisit(node);
            }
        }
    }
    public void dfsVisit(Graphnode node){
        Stack<Graphnode> stack  = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            Graphnode currentnode = stack.pop();
            currentnode.isVisited = true;
            System.out.println(currentnode.name+" ");
            ArrayList<Graphnode> neighbors = getNeighbors(currentnode);
            for(Graphnode neighbor:neighbors){
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }
    public void dfs(){
        for(Graphnode node:nodeList){
           if(!node.isVisited){
               dfsVisit(node);
           }
        }
    }
    public static void pathPrint(Graphnode node){
        if(node.parent != null){
            pathPrint(node.parent);
        }
        System.out.println(node.name+" ");
    }
    public void BFSFORSSSPP(Graphnode node){
        LinkedList<Graphnode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Graphnode currentnode = queue.remove(0);//to remove the first element from the queue
            currentnode.isVisited = true;
            System.out.println("Printing the path for node"+currentnode.name+" :");
            pathPrint(currentnode);
            System.out.println();
            ArrayList<Graphnode> neighbors = getNeighbors(currentnode);
            for(Graphnode neighbor:neighbors){
                if(!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentnode;
                }
            }
        }
    }
}
