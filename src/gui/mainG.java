package gui;
import javax.swing.JFrame;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import utils.Point3D;
public class mainG 
{
		public static void main(String[] args) 
		{
			Point3D p1 = new Point3D(30,40,0);
			Point3D p2 = new Point3D(60,50,0);
			Point3D p3 = new Point3D(30,80,0);
			Point3D p4 = new Point3D(50,40,0);
			Point3D p5 = new Point3D(70,80,0);

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
			Graph_GUI gg = new Graph_GUI(g);
			gg.setVisible(true);

		}

	
}
