package Graph_Framework;

import RoadDesignApp.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Graph { //Graph: It defines the structure of a graph.

    int verticesNo;       /*number of vertices of the graph. It should be incremented 
                          whenever a function a new object is added to the vertex list.   */
    int edgeNo;          //edgeNo: number of edges of the graph.
    boolean isDigraph;   //Set to true if the graph is directed graph, and set to false if the graph is undirected.
    Vertex[] vertices;     //vertices attribute is a list/vector  representing the list of vertices of a graph
    Edge[] edges;
    

    
  public Graph() {
}
//----------------------------------------------
    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
      this.verticesNo = verticesNo;
      this.edgeNo = edgeNo;
      this.isDigraph = isDigraph;     
      vertices = new Vertex[verticesNo];
  }
//----------------------------------------------

  /*This function takes as parameters: number of vertices and the number of edges.
     It is responsible for creating a graph object with the specified parameters and
     randomly initializes the vertices’ labels,
     creating edges that connects the created vertices randomly and assigning them random weights. 
    Make sure that the resulting graph is connected.  */
    

  public void makeGraph(int numOfVertices, int numOfEdges) {
    Random random = new Random();
    // --- STEP 1: Create the graph ---
    //Create arrayList to store the used label (avoid duplicated label)
    //ensuring all vertex has unique label
    ArrayList<Integer> checkList = new ArrayList<>(numOfVertices);
    for (int i = 0; i < numOfVertices; i++) {
        int randomLabel = random.nextInt(numOfVertices); //generate random integer from 0 to vertices number-1 to label vertices
        if (!checkList.contains(randomLabel)) {         //if checkList doesn't contain the randomLabel
            //then create vertex with randomLabel and add it to the array of vertices in randomLabel indes
            //to faster direct access later
            vertices[randomLabel] = new Vertex(randomLabel);
            //add the randomLabel to checkList to avoid choice it as label for another verex again
            checkList.add(randomLabel);
        } //if the checkList contains the randomLabel decrement i by 1 
        //to generate another random label again for the same vertex
        //if not doing this some vertices will not created and will be null 
        else {
            --i;
        }
    }

    // --- STEP 2: create the necessary edges to ensuring the graph is connected ---
    for (int i = 0; i < numOfVertices - 1; i++) {
        //generate random integer from 1 to 50(included) to weight the edge 
        int randomWeight = random.nextInt(50) + 1;
        //invoking addEdge to create edge between vertices[i - 1] and vertices[i]
        addEdge(vertices[i], vertices[i + 1], randomWeight);
    }

    //calculate the remainig edges to generate it randomly
    int remaning = edgeNo - (verticesNo - 1);

    // --- STEP 3: Add the remainig edges randomly ---
    for (int i = 0; i < remaning; i++) {
        //sourceID is the vertex that will have an adjacent vertex
        int sourceId = (int) (Math.random() * (verticesNo));
        //destinationID randomly chooses which vertex to add to sourceID as an adjacent
        int destinationId = (int) (Math.random() * (verticesNo));
        /* Avoid self-edges or having an adjacent vertex that already exists
            1- A self-edge happens when the sourceID = destinationID, thus the vertex will point to itself as an adjacent
            2- An adjacent that already exists: when we want to add a new adjacent vertex yet it already exists
        If one of these cases appeared, the iteration should not be counted and should be ignored without
        affecting the number of wanted edges in the graph
        We will avoid those cases by using the following if statement
         */
        if (sourceId == destinationId || isDuplicated(sourceId, destinationId) || isDuplicated(destinationId, sourceId)) {
            --i; // Since this iteration should not be counted, decrease i
            continue; // Skip this iteration
        }
        //initiate the weight value as well
        int randomWeight = (int) (1 + Math.random() * 50);
        //invoking addEdge to create edge between vertices[sourceId] and vertices[destinationId]
        addEdge(vertices[sourceId], vertices[destinationId], randomWeight);
    }
}


    //This method to check if the edge already exists (to avoid duplicate)
    public boolean isDuplicated(int SourceId, int DestinationId) { //return true if the edge between this vertices already exists and false if not
        //for loop walk through all the edge in adjList of the source
        for (Edge edge : vertices[SourceId].adjList) {
            //check if the source label of the edge = sourceId "and" destination label of the edge = detinationId
            if ((edge.source.getLabel() == SourceId && edge.target.getLabel() == DestinationId)) {
                //return true
                return true;
            }
        }
        //if there is no edge have this sourceId and detinationId return false
        return false;
    }



    //-------------------------------------------------------------------------------------



    public void addEdge(Vertex sourceId, Vertex destinationId, int weight) {
        //create edge's object
        Edge edge = new Edge(sourceId, destinationId, weight);
        //add the edge to the source's adjList
        sourceId.adjList.add(edge);
        //is undirected graph create another edge with the destinationId as source and add it to the destiantion adjList
        if (!isDigraph) {
            //create another edge's object(the destination will be the source and source will be destination)
            Edge edge2 = new Edge(destinationId, sourceId, weight);
            //add it to the destination adjList
            destinationId.adjList.add(edge2); //for undirected graph
        }
        
    

} }

/* 
     public static void printGraph(LinkedList<Edge> edgeList) {
      int cost = 0;
      for (int i = 0; i < edgeList.size(); i++) {
          Edge edge = edgeList.get(i);
          cost += edge.getWeight();
      }
      System.out.println("Minimum Spanning Tree Cost = " + cost);
  }
*/

  

    /*It reads the edges and vertices from the text file whose name is specified by the parameter filename and place data in a Graph object.
        In this project, you need to create a text file that contains the graph presented in requirement 1.
        The file format is shown in Appendix II.
        It is responsible for doing some preprocessing then
        call the addEdge() method to determine the position of the Edge
 */
//NOT WORKING

/*
public void readGraphFromFile() throws FileNotFoundException{
    File file=new File("C:/Users/96654/Desktop/Algorithm/Graph_Framework/newFile.txt");
    if(!file.exists()) { System.exit(0);}  
 
    Scanner input=new Scanner(file);
    int label=0;
    input.next(); //The word "digraph"
    int type =input.nextInt();  //0 or 1
    int verticesNo=input.nextInt();
    int edgesNo=input.nextInt();    
    edges=new Edge[edgesNo];
    Graph graph = new Graph(verticesNo,edgesNo, false);
    
    ArrayList<Edge> newGraph = new ArrayList<>(verticesNo);

while(input.hasNext()){
for (int i = 0; i <verticesNo; i+=2) {
    label=(int)(input.next().charAt(0)-65);
    vertices[i] = new Vertex(label);
    label=(int)(input.next().charAt(0)-65);
    vertices[i+1] = new Vertex(label);

  
int Weight = input.nextInt();
 //invoking addEdge to create edge between vertices[i - 1] and vertices[i]
 addEdge(vertices[i], vertices[i + 1], Weight);
} }


     //ANOTHER TRIAL 
            int eInd =0;
            while(input.hasNext()){
                String[] details = input.nextLine().split(" ");
                sourceId.adjList.add(edge);
                char source=input.next().charAt(0);
                Vertex c=new Vertex();
            
                if(details[0].equals("A")){
                    graph.edge[eInd].source.setLabel(0); 
                } else if(details[0].equals("B")){
                    graph.edge[eInd].source.setLabel(1);
                } else if(details[0].equals("C")){
                    graph.edge[eInd].source.setLabel(2);
                } else if(details[0].equals("D")){
                    graph.edge[eInd].source.setLabel(3);
                } else if(details[0].equals("E")){
                    graph.edge[eInd].source.setLabel(4);
                } else if(details[0].equals("F")){
                    graph.edge[eInd].source.setLabel(5);
                }
                if(details[1].equals("A")){
                    graph.edge[eInd].target.setLabel(0);
                } else if(details[1].equals("B")){
                    graph.edge[eInd].target.setLabel(1);
                } else if(details[1].equals("C")){
                    graph.edge[eInd].target.setLabel(2);
                } else if(details[1].equals("D")){
                    graph.edge[eInd].target.setLabel(3);
                } else if(details[1].equals("E")){
                    graph.edge[eInd].target.setLabel(4); 
                } else if(details[1].equals("F")){
                    graph.edge[eInd].target.setLabel(5);
                }

                graph.edge[eInd].weight = Integer.parseInt(details[2]);
                eInd++;
            } */
           // KruskalAlg.kruskalMST(vertices, edges);
            //graph.KruskalMST();
            //graph.prim();
          
           // input.close();
          
         


    






