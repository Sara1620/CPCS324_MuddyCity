package Graph_Framework;



public class Edge { //It represents a graph's edge.

    public int weight;     // An int value, that holds the weight assigned to the edge connecting the source and target  vertices.
    Vertex parent; //It represents the parent of target vertex/source vertex, depending on the application.
    Vertex source;
    Vertex target;
    

    public Edge() {
    }

    public Edge(int weight) {
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        }

    public void setParent(Vertex parent) {
        this.parent = parent; 
    }

    public void setSourceVertix(Vertex source) {
        this.source = source; 
    }

    public void setTargetVertix(Vertex target) {
        this.target = target;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public Vertex getSourceVertix() {
        return source;
    }

    public Vertex getTargetVertix() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

   public String displayInfo(){ //method is responsible for displaying the information of the class attributes.
    return "parent: "+ (char)(parent.label) +"source: "+ (char)(source.label) + "- " +"target "+ (char)(target.label) + " weight is: " + weight);

    }
}

