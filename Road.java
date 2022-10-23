package RoadDesignApp;

import Graph_Framework.Edge;

public class Road extends Edge{
 
    int RoadSize=weight*3;  //The roadSize attribute is 3 times the weight of the corresponding edge. 

    public String displayInfo() //Override/complete the displayInfo() method to display the information of the class attributes.
    { 
        return "Road size: "+RoadSize;
    }
}
