package Graph_Framework;

import java.util.*;

public class KruskalAlg extends MSTAlgorithm{ /* Subclass of MSTAlgorithm. It implements the polymorphic operation displayResultingMST().*/

  
        public int KruskalAlgorithm(Graph graph) {
            //Priorty queue to insert edge and sorted it by weight 
            PriorityQueue<Edge> priorityQueueVar = new PriorityQueue<>(graph.edgeNo, Comparator.comparingInt(o -> o.weight));
    
            //add all the edges to priority queue, sort the edges on weights
            for (int i = 0; i < graph.verticesNo; i++) {
                for (int j = 0; j < graph.vertices[i].adjList.size(); j++) {
                    priorityQueueVar.add(graph.vertices[i].adjList.get(j));
                }
            }
     
            //create array of edge of length equal to verticesNo 
            //this array will make new edge object to each vertex and store the parent of the vertex in it
            Edge[] parent = new Edge[graph.verticesNo];
            //makeset --> intially every vertex will be in its own set (the parent of itself)
            makeSet(parent, graph.verticesNo);
    
            //Declaration of the superclass attribute 
            MSTResultList = new Edge[graph.verticesNo - 1];
            //intialize counter to count number of edges 
            int edgeCounter = 0;
            //while loop to process vertices - 1 edges
            while (edgeCounter < graph.verticesNo - 1 && !priorityQueueVar.isEmpty()) {
                //remove the front from the proirty queue (least weight)
                Edge edge = priorityQueueVar.remove();
                //check if adding this edge creates a cycle find the parent list of the source and destination of the edge
                int src_set = find_parent(parent, edge.source.label);
                int dst_set = find_parent(parent, edge.target.label);
                //if the parent set of the source and destination is equal that means they are in the same set
                if (src_set == dst_set) {
                    //ignore, will create cycle
                } else {
                    //add it to our final result set
                    MSTResultList[edgeCounter] = edge;
                    //increment the index of the number of edges 
                    edgeCounter++;
                    //union the two set
                    union(parent, src_set, dst_set);
                }
            }
            //return the cost by call displayResultingMST method to calculate the cost
            return displayResultingMST(MSTResultList);
        }
    
    
    public void makeSet(Edge[] parentArray, int verticesNo) { //intially every parent set will have the vertex label as parent label
        for (int i = 0; i < verticesNo; i++) {
            parentArray[i] = new Edge();
            parentArray[i].parent = new Vertex(i);
        }
    }


    public void union(Edge[] parentArray, int x, int y) {
        //find the key of set of x 
        int setXparent = find_parent(parentArray, x);
        //find the key of set of y 
        int setYparent = find_parent(parentArray, y);
        //make y as parent of x
        parentArray[setXparent].parent.label = setYparent;
    }

    public int find_parent(Edge parentArray[], int vertexLabel) { //array of edges contains the parent of all the vertices
                                                               //vertexLabel: the label of vertex to search about its parent
        //if the parentArray[vertexLabel].parent.label == v then return v
        if (parentArray[vertexLabel].parent.label == vertexLabel) {
            return vertexLabel;
        }
        //if not continue searching 
        return find_parent(parentArray, parentArray[vertexLabel].parent.label);
    }


 public int displayResultingMST(Edge[] edgesList) { 
    int cost = 0;
    //for loop to calculate the cost of all edge in minimum spanning tree 
    for (int i = 0; i < edgesList.length; i++) {
        Edge edge = edgesList[i];
        //add weight to the cost
        cost += edge.weight;
    }
    //return cost
    return cost;
}
  


}

  

