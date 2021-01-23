import java.io.*;

class DecisionTreeMain {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter space separated attribute names:");
		String[] attributes = br.readLine().split("\\s");
		//for (String attribute: attributes) System.out.println(attribute);
	}
}
