package Graph_Framework;



public abstract class MSTAlgorithm { /*It is a superclass representing the general characteristics of an algorithm for computing 
                             the minimum spanning tree. It has three subclasses: KruskalAlg, MHPrimAlg and PQPrimAlg. */

    Graph graph;
    Edge[] MSTResultList; /*It is a list of objects of the type Edge.
                         It stores the parent of the vertex and the weight needed by the MST algorithm */
    

 public abstract int displayResultingMST(Edge[] edgesList); //Abstract function that should be implemented by the subclasses’ polymorphic functions.
    
 
}

