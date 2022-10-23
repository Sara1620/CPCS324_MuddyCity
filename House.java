package RoadDesignApp;

import Graph_Framework.Vertex;

public class House extends Vertex{

     static String[] houseName; // store X1, X2,… or x15 – starts with x followed by a unique number

     
     public void values()
     {
        for (int i=0;i<15;i++)
        houseName[i]="X"+(i+1);

     }
    public String displayInfo() //Override/complete the displayInfo() method to display the information of the class attributes.
    { 
        return "house name: ";

    }
}
