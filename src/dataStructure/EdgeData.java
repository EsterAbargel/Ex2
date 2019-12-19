package dataStructure;

public class EdgeData implements edge_data {
	private node_data src,dest;
	private double weight;
	private int tag;
	String info="";
	
	public EdgeData(node_data src,node_data dest,double weight) {
		this.src=src;
		this.dest=dest;
		this.weight=weight;
	}

	@Override
	public int getSrc() {
		// TODO Auto-generated method stub
		return this.src.getKey();
	}

	@Override
	public int getDest() {
		// TODO Auto-generated method stub
		return this.dest.getKey();
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		// TODO Auto-generated method stub
		this.info=s;
	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		// TODO Auto-generated method stub
		this.tag=t;
	}

}
