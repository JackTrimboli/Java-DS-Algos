/*package GraphDS;
import java.util.*;

public class Graph {
    private final int vCount; // number of vertices
	private int eCount; // Number of edges
	
	private final ArrayList<Integer>[] adjacents; // array of integer lists
	
	public Graph(final int vCount){
		this.vCount = vCount;
		this.eCount = 0;
		adjacents = new ArrayList[vCount];
		
		for(int i = 0; i < vCount; i++){
			adjacents[i] = new ArrayList<Integer>();
		}
	}
	
	public int getVertexCount(){
		return vCount;
	}
	
	public int getEdgeCount(){
		return eCount;
	}
	
	public void addEdge(final int src, final int dest){
		adjacents[src].add(dest);
		eCount++;
	}
	
	public Object[] adj(final int src){
		return adjacents[src].toArray();
	}
}
*/
