package RoadDesignApp;

import Graph_Framework.*;
import java.util.*;
import java.io.*;

public class RoadDesignApp {//It is the starting point of the program and contains the main function

    Graph cityMap;
    public static void main(String[]Args) throws FileNotFoundException   /* this function should be responsible for:
                                               -running the readGraphFromFile method for requirement1 and
                                               -running the make graph function for requirement 2 to:
                                                     initialize the graph and
                                                     invoking the 2 algorithm and
                                                     displaying the returned results and the measured running time.
                                                The output should show the requested comparison between the results & run time of the algorithms */
/*Make sure that you create objects of the Graph(grom graph framework), House and Road classes,
 do not make objects of Vertex and Edge (from graph framework) */
{ 
    //TO READ FROM FILE
    //Graph readGraphKS,readGraphPQ;
    //long  cost_ks_read, cost_pq_read;
   
   // File file=new File("newFile.txt");
    //Scanner read=new Scanner(file); 
    Scanner input=new Scanner(System.in);


    int numOfVertices = 0;
    int numOfEdges = 0;
    Graph graph;
    int Choice_Case;
   
    System.out.println("*******************************************************************************************");
    System.out.println("                  Muddy city problem             ");
    System.out.println("*******************************************************************************************\n");

    System.out.println("Test Cases: ");
    System.out.println("1-  numOfVertices=1,000 - numOfEdges=10,000");
    System.out.println("2-  numOfVertices=1,000 - numOfEdges=15,000");
    System.out.println("3-  numOfVertices=1,000 - numOfEdges=25,000");
    System.out.println("4-  numOfVertices=5,000 - numOfEdges=15,000");
    System.out.println("5-  numOfVertices=5,000 - numOfEdges=25,000");
    System.out.println("6-  numOfVertices=10,000 - numOfEdges=15,000");
    System.out.println("7-  numOfVertices=10,000 - numOfEdges=25,000");
    System.out.print("Choice_Case: " );
    Choice_Case= input.nextInt();
    KruskalAlg ks = new KruskalAlg();
    PQPrimAlg pq = new PQPrimAlg();

    double startTime_kruskal, finishTime_kruskal;
    double startTime_primPQ, finishTime_primPQ;

    long cost_ks,cost_pq;


          
          switch (Choice_Case) {
              case 1: {
                  numOfVertices = 1000;
                  numOfEdges = 10000;
                  break;
              }
              case 2: {
                  numOfVertices = 1000;
                  numOfEdges = 15000;
                  break;
              }
              case 3: {
                  numOfVertices = 1000;
                  numOfEdges = 25000;
                  break;
              }
              case 4: {
                  numOfVertices = 5000;
                  numOfEdges = 15000;
                  break;
              }
              case 5: {
                  numOfVertices = 5000;
                  numOfEdges = 25000;
                  break;
              }
              case 6: {
                  numOfVertices = 10000;
                  numOfEdges = 15000;
                  break;
              }
              case 7: {
                  numOfVertices = 10000;
                  numOfEdges = 25000;
                  break;
              }

          }

        graph = new Graph(); 
        graph.makeGraph(numOfVertices,numOfEdges);  // Generate graph randomly 
       
        

         //Perform kruskal and prim priority queue
            startTime_kruskal = System.nanoTime();
            cost_ks = ks.KruskalAlgorithm(graph); //Call KruskalAlg to find minimum-spanning-tree and cost of graph, store the returned values 
            finishTime_kruskal = System.nanoTime();

            startTime_primPQ = System.nanoTime();
            cost_pq = pq.PQPrimAlgorithm(graph); //Call PQPrimAlg to find minimum-spanning-tree and cost of graph, store the returned values
            finishTime_primPQ = System.nanoTime();

            //Print total time of Kruskal's Algorithm & Prim's PriorityQueue Algorithm 
            System.out.println("Total runtime of Kruskal's Algorithm : " + ((finishTime_kruskal - startTime_kruskal) / 1000000) + " ms.");
            System.out.println("Total runtime of Prim's PriorityQueue Algorithm : " + ((finishTime_primPQ - startTime_primPQ) / 1000000) + " ms.");

            //Print minimum spanning tree cost of Kruskal's Algorithm & Prim's PriorityQueue Algorithm 
            System.out.println("\nMinimum Spanning Tree Cost of  Kruskal's Algorithm : " + cost_ks);
            System.out.println("Minimum Spanning Tree Cost of Prim's PriorityQueue Algorithm : " + cost_pq);
            input.close();
      
  
//For reading from file, NOT WORKING
  /*   readGraphKS=new Graph();
    readGraphKS.readGraphFromFile();
    cost_ks_read=ks.KruskalAlgorithm(readGraphKS);
    System.out.println("cost is "+cost_ks_read);
    readGraphPQ=new Graph();
    readGraphPQ.readGraphFromFile();
    cost_pq_read=pq.PQPrimAlgorithm(readGraphKS);
    System.out.println("cost is "+cost_pq_read);
    */
}
    
}

        
      

       

