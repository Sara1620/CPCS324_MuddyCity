package Graph_Framework;

import java.util.*;


public class PQPrimAlg extends MSTAlgorithm{ /*Subclass of MSTAlgorithm. It implements the polymorphic operation displayResultingMST(). */
    

    public int PQPrimAlgorithm(Graph graph) {
        // initialize a PriorityQueue that will keep track of the possible edges that
        // we can add to the tree we are forming, and will allow us to select the 
        // edge of least cost every step of the way
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(graph.verticesNo, Comparator.comparingInt(o -> o.weight));
        // mark the initial vertex as visited
        graph.vertices[0].isVisited = true;

        // for every edge connected to the source, add it to the PriorityQueue
        for (Edge edge : graph.vertices[0].adjList) {
            priorityQueue.add(edge);
        }

        //counter to count the edges
        int edgeCounter = 0;
        //Declaration of the superclass attribute 
        MSTResultList = new Edge[graph.verticesNo - 1];
        // keep adding edges until the PriorityQueue is empty
        while (edgeCounter < graph.verticesNo - 1 && !priorityQueue.isEmpty()) {
            //remove the front from the priority queue(least weight)
            Edge e = priorityQueue.remove();

            // if we have already visited the opposite vertex, go to the next edge
            if (graph.vertices[e.target.label].isVisited) {
                continue;
            }
            // mark the opposite vertex as visited
            graph.vertices[e.target.label].isVisited = true;
            //add the edge to the final set 
            MSTResultList[edgeCounter] = e;
            //increment the index of the number of edges 
            edgeCounter++;
            // for every edge connected to the opposite vertex, add it to the PriorityQueue
            for (Edge neighbor : graph.vertices[e.target.label].adjList) {
                priorityQueue.add(neighbor);
            }
        }
        //return the cost by call displayResultingMST method to calculate the cost
        int cost = displayResultingMST(MSTResultList);
        return cost;
    }

public int displayResultingMST(Edge[] edgeList) { //EdgeList: it is the array of edges that is included in the minimum spanning tree
    int cost = 0;
    
    for (int i = 0; i < edgeList.length; i++) {//for loop to calculate the cost of all edge in minimum spanning tree 
        Edge edge = edgeList[i];
        cost += edge.weight;
    }

    return cost;
}


}
  


   

  
   
