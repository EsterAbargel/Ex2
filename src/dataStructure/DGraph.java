package dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class DGraph implements graph{
	
	private HashMap<Integer,node_data> nd=new HashMap<>();
	private HashMap<node_data,edge_data> e=new HashMap<>();
	private HashMap<node_data,HashMap<node_data,edge_data>> ed=new HashMap<>();
	public static int mc=0;
	
	public DGraph(NodeData [] vertices,EdgeData[] edge) {
		for(int i=0;i<vertices.length;i++) {
			this.addNode(vertices[i]);
		}
		for(int j=0;j<edge.length;j++) {
			this.connect(edge[j].getSrc(), edge[j].getDest(), edge[j].getWeight());
		}
		
		
	}
	
	@Override
	public node_data getNode(int key) {
		return  nd.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return ed.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		nd.put(n.getKey(), n);
		
	}

	@Override
	public void connect(int src, int dest, double w) {
		EdgeData tempEdge=new EdgeData(nd.get(src),nd.get(dest),w);
		e.put(nd.get(dest), tempEdge);
		ed.put(nd.get(src), e);
		
		
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return nd.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return ed.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return nd.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return ed.get(src).remove(dest);
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return nd.size();
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return ed.size();
	}

	@Override
	public int getMC() {
		return mc;
	}

}
