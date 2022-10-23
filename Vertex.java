package Graph_Framework;
import java.util.LinkedList;

public class Vertex{ //It represents the graph's vertex

    int label;                  //a number that represents the vertex label.
     boolean isVisited=false;    /* It is initialized by false  and then set to true if the current vertex is visited  */                            
    static LinkedList<Edge> adjList;   /* adjList attribute should be an implementation of a linked list
                                as it represents the adjacency list of a vertex within a class. */

    

                                
    public Vertex() {
    }

    public Vertex(int label) {
        this.label = label;
        adjList = new LinkedList<>();
    }


    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label=label;
    }

    public void setIsVisited(Vertex target)
    {this.isVisited=true;

    }
    public boolean getIsVisited()
    {return isVisited;

    }

    public String displayInfo(){  // It is responsible for displaying the information of the class attributes
        return"---Vertex: " + label +" IsVisited? "+isVisited;

    }

   

}

