package data;

import java.util.Vector;

public class Row {

	private int line;
	private Vector<String> dataset = new Vector<>();
	private double weight;
	private int incomplete;
	
	public Row() {
		// TODO Auto-generated constructor stub
		dataset.clear();
		weight = 1;
		incomplete = -1;
	}
	
	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public Vector<String> getDataset() {
		return dataset;
	}

	public void setDataset(Vector<String> dataset) {
		this.dataset = dataset;
		for (int i = 0; i < dataset.size(); i++) {
			if (dataset.get(i).equals("?"))
				incomplete = i;
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getIncomplete() {
		return incomplete;
	}

	public void setIncomplete(int incomplete) {
		this.incomplete = incomplete;
	}

	public int getSize() {
		return dataset.size();
	}

	public boolean match(int loc, String value) {
		return dataset.get(loc).equals(value);
	}
	
	public void setData(int l, String[] values) {
		line = l;
		for (int i = 0; i < values.length; i++) {
			dataset.add(values[i]);
			if (values[i].equals("?"))
				incomplete = i;
		}
		weight = 1;
	}

	public void replaceIncompleteData(String value) {
		if (incomplete != -1)
			dataset.set(incomplete, value);
	}
	
	public void addData(String d) {
		dataset.add(d);
		if (d.equals("?"))
			incomplete = dataset.size() - 1;
	}
	
	public String[] toStringArray() {
		String[] res = new String[dataset.size()];
		for (int i = 0; i < dataset.size(); i++) {
			res[i] = dataset.get(i);
		}
		return res;
	}	
}
