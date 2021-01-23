import java.util.ArrayList;

class DataSet{
	private ArrayList<String[]> dataSet;
	private ArrayList<String> attributes;
	
	DataSet(String[] attributes) {
		this.attributes = new ArrayList(Arrays.asList(attributes));
	}
}
