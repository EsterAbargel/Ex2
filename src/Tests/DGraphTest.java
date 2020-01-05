package Tests;

import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import utils.Point3D;


public class DGraphTest {


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
	DGraph g=new DGraph(node , edge);


	@Test
	public void testGetNode() {
		int expected=3;
		int actual=g.getNode(3).getKey();
		if(actual!=expected) {
			fail("getNode test");
		}

	}

	@Test
	public void testGetEdge() {
		NodeData ne = new NodeData(0,p1);
		NodeData ne1 = new NodeData(1,p2);
		EdgeData expected=new EdgeData(ne,ne1,1);
		EdgeData actual=(EdgeData) g.getEdge(0, 1);
		if(!(expected.toString().equalsIgnoreCase(actual.toString()))) {
			fail("getEdge test");
		}

	}

	@Test
	public void testGetV() {
		int expected=5;
		int actual=g.getV().size();
		if(actual!=expected) {
			fail("getV test");
		}
	}
	@Test
	public void testGetMc() {
		DGraph actual=new DGraph(node,edge);
		if(actual.getMC()!=(actual.nodeSize()+actual.edgeSize())) {
			System.out.println(actual.nodeSize());
			System.out.println(actual.edgeSize());
			System.out.println(actual.getMC());
			fail("getMc test");
		}
	}
	@Test
	public void testRemoveNode() {
		g.removeNode(0);
		if(g.getNode(0)!=null) {
			fail("removeNode test");
		}

	}

	@Test
	public void testRemoveEdge() {
		g.removeEdge(2,3);
		if(g.getEdge(2, 3)!=null) {
			fail("removeEdge test");
		}
	}


	@Test
	public void testNodeSize() {
		if(g.nodeSize()!=5) {
			fail("nodeSize test");
		}
	}

	@Test
	public void testEdgeSize() {
		if(g.edgeSize()!=6) {
			fail("edgeSize test");
		}
	}
	@Test
	public void testAddNode() {
		NodeData expected=new NodeData(5,p1);
		g.addNode(expected);
		if(g.getNode(5)==null) {
			fail("addNode test");
		}
	}

	@Test
	public void testConect() {
		g.connect(1, 4, 3);
		if(g.getEdge(1, 4)==null) {
			fail("connect test");
		}
	}


	@Test
	public void testGetE() {
		int expected=2;
		int actual=g.getE(3).size();
		if(actual!=expected) {
			fail("GetE test");
		}
	}



}
