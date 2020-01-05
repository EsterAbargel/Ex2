package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import dataStructure.node_data;
import utils.Point3D;

class Graph_AlgoTest {
	Point3D p1 = new Point3D(0,1,0);
	Point3D p2 = new Point3D(1,1,0);
	Point3D p3 = new Point3D(1,0,0);
	Point3D p4 = new Point3D(0,0,0);
	Point3D p5 = new Point3D(0,2,0);

	NodeData n0 = new NodeData(0,p1);
	NodeData n1 = new NodeData(1,p2);
	NodeData n2 = new NodeData(2,p3);
	NodeData n3 = new NodeData(3,p4);
	NodeData n4 = new NodeData(4,p5);

	EdgeData e1 = new EdgeData(n0, n1, 1);
	EdgeData e2 = new EdgeData(n1, n2, 2);
	EdgeData e3 = new EdgeData(n2, n3, 5);
	EdgeData e4 = new EdgeData(n3, n4, 3);
	EdgeData e5 = new EdgeData(n4, n2, 4);
	EdgeData e6 = new EdgeData(n3, n0, 10);
	EdgeData edge[]= {e1,e2,e3,e4,e5,e6};
	NodeData node[] = {n0,n1,n2,n3,n4};
	DGraph g = new DGraph(node , edge); 
	Graph_Algo G=new Graph_Algo();

	@BeforeEach
	void setUp() {
		G.init(g);
	}

	@Test
	void testInitSaveCopy() {
		G.save("Test.txt");
		Graph_Algo G2=new Graph_Algo();
		G2.init("Test.txt");
		DGraph actual=(DGraph) G2.copy();
		if(actual.getV().size()!=g.getV().size()) {
			fail("init and save");
		}
		Iterator<?> iterG =g.getV().iterator();
		Iterator<?> iterActual =actual.getV().iterator();
		while(iterG.hasNext()&&iterActual.hasNext()) {
			node_data gNode= (node_data) iterG.next();
			node_data actualNode= (node_data) iterActual.next();
			if(gNode.getKey()!=actualNode.getKey()) {
				fail("init and save test");
			}
		}
	}

	@Test
	void testShortestPathDist() {
		double expected=7;
		double actual=G.shortestPathDist(3, 2);
		if(actual!=expected) {
			fail("shortestPathDist test");
		}
	}
	@Test
	void testShortestPath() {
		LinkedList<node_data> expected=new LinkedList<>();
		expected.add(n3);
		expected.add(n4);
		expected.add(n2);
		List<node_data> actual=G.shortestPath(3, 2);
		if(actual.size()!=expected.size()) {
			fail("shortest path test");
		}
		Iterator<node_data> iterExpected =expected.iterator();
		Iterator<node_data> iterActual =actual.iterator();
		while(iterExpected.hasNext()&&iterActual.hasNext()) {
			node_data expectedNode= (node_data) iterExpected.next();
			node_data actualNode= (node_data) iterActual.next();
			if(expectedNode.getKey()!=actualNode.getKey()) {
				fail("shortest path test");
			}
		}
	}
	@Test
	void testIsConnected() {
		boolean actual=G.isConnected();
		if(!actual) {
			fail("isConnected test");
		}
	}
	@Test
	void testTSP() {
		LinkedList <Integer> targets=new LinkedList<>();
		targets.add(3);
		targets.add(1);
		targets.add(0);
		targets.add(4);
		List<node_data> actual=G.TSP(targets);
		List<node_data> expected=new LinkedList<>();
		expected.addAll(G.shortestPath(3, 1));
		expected.addAll(G.shortestPath(1, 0));
		expected.addAll(G.shortestPath(0, 4));
		for(int i=0;i<expected.size()-1;i++) {
			if(expected.get(i).getKey()==expected.get(i+1).getKey()) {
				expected.remove(i);
			}
		}
		Iterator<node_data> iterExpected =expected.iterator();
		Iterator<node_data> iterActual =actual.iterator();
		while(iterExpected.hasNext()&&iterActual.hasNext()) {
			node_data expectedNode= (node_data) iterExpected.next();
			node_data actualNode= (node_data) iterActual.next();
			if(expectedNode.getKey()!=actualNode.getKey()) {
				fail("TSP test");
			}
		}
	}
}
