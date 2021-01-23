import java.io.*;

import java.util.*;

public class ID3

{

int numAttributes;

String []attributeNames;

Vector []domains;

/* The class to represent a data point consisting of numAttributes values

of attributes */

class DataPoint {

public int []attributes;

public DataPoint(int numattributes) {

attributes = new int[numattributes];

}

};



/* The class to represent a node in the decomposition tree.

*/

class TreeNode {

public double entropy;

public Vector data;

public int decompositionAttribute;

public int decompositionValue;

public TreeNode []children;

public TreeNode parent;

public TreeNode() {

data = new Vector();

}

};

TreeNode root = new TreeNode();

public int getSymbolValue(int attribute, String symbol) {

int index = domains[attribute].indexOf(symbol);

if (index < 0) {

domains[attribute].addElement(symbol);

return domains[attribute].size() -1;

}

return index;

}



public int []getAllValues(Vector data, int attribute) {

Vector values = new Vector();

int num = data.size();

for (int i=0; i< num; i++) {

DataPoint point = (DataPoint)data.elementAt(i);

String symbol =

(String)domains[attribute].elementAt(point.attributes[attribute] );

int index = values.indexOf(symbol);

if (index < 0) {

values.addElement(symbol);

}

}

int []array = new int[values.size()];

for (int i=0; i< array.length; i++) {

String symbol = (String)values.elementAt(i);

array = domains[attribute].indexOf(symbol);

}

values = null;

return array;

}





public Vector getSubset(Vector data, int attribute, int value) {

Vector subset = new Vector();

int num = data.size();

for (int i=0; i< num; i++) {

DataPoint point = (DataPoint)data.elementAt(i);

if (point.attributes[attribute] == value) subset.addElement(point);

}

return subset;

}





public double calculateEntropy(Vector data) {

int numdata = data.size();

if (numdata == 0) return 0;

int attribute = numAttributes-1;

int numvalues = domains[attribute].size();

double sum = 0;

for (int i=0; i< numvalues; i++) {

int count=0;

for (int j=0; j< numdata; j++) {

DataPoint point = (DataPoint)data.elementAt(j);

if (point.attributes[attribute] == i) count++;

}

double probability = 1.*count/numdata;

if (count > 0) sum += -probability*Math.log(probability);

}

return sum;

}

public boolean alreadyUsedToDecompose(TreeNode node, int attribute) {

if (node.children != null) {

if (node.decompositionAttribute == attribute )

return true;

}

if (node.parent == null) return false;

return alreadyUsedToDecompose(node.parent, attribute);

}

public void decomposeNode(TreeNode node) {

double bestEntropy=0;

boolean selected=false;

int selectedAttribute=0;

int numdata = node.data.size();

int numinputattributes = numAttributes-1;

node.entropy = calculateEntropy(node.data);

if (node.entropy == 0) return;



for (int i=0; i< numinputattributes; i++) {

int numvalues = domains.size();

if ( alreadyUsedToDecompose(node, i) ) continue;

double averageentropy = 0;

for (int j=0; j< numvalues; j++) {

Vector subset = getSubset(node.data, i, j);

if (subset.size() == 0) continue;

double subentropy = calculateEntropy(subset);

averageentropy += subentropy *

subset.size();

}

averageentropy = averageentropy / numdata; //

Taking the weighted average

if (selected == false) {

selected = true;

bestEntropy = averageentropy;

selectedAttribute = i;

} else {

if (averageentropy < bestEntropy) {

selected = true;

bestEntropy = averageentropy;

selectedAttribute = i;

}

}

}

if (selected == false) return;

int numvalues = domains[selectedAttribute].size();

node.decompositionAttribute = selectedAttribute;

node.children = new TreeNode [numvalues];

for (int j=0; j< numvalues; j++) {

node.children[j] = new TreeNode();

node.children[j].parent = node;

node.children[j].data = getSubset(node.data,

selectedAttribute, j);

node.children[j].decompositionValue = j;

}



for (int j=0; j< numvalues; j++) {

decomposeNode(node.children[j]);

}



node.data = null;

}





public int readData(String filename) throws Exception {

FileInputStream in = null;

try {

File inputFile = new File(filename);

in = new FileInputStream(inputFile);

} catch ( Exception e) {

System.err.println( "Unable to open data file: " + filename + "\n" + e);

return 0;

}

BufferedReader bin = new BufferedReader(new InputStreamReader(in) );

String input;

while(true) {

input = bin.readLine();

if (input == null) {

System.err.println( "No data found in the data file: " + filename +

"\n");

return 0;

}

if (input.startsWith("//")) continue;

if (input.equals("")) continue;

break;

}



StringTokenizer tokenizer = new StringTokenizer(input);

numAttributes = tokenizer.countTokens();

if (numAttributes <= 1) {

System.err.println( "Read line: " + input);

System.err.println( "Could not obtain the names of attributes in the

line");

System.err.println( "Expecting at least one input attribute and one

output attribute");

return 0;

}

domains = new Vector[numAttributes];

for (int i=0; i < numAttributes; i++) domains = new Vector();

attributeNames = new String[numAttributes];

for (int i=0; i < numAttributes; i++) {

attributeNames = tokenizer.nextToken();

}



while(true) {

input = bin.readLine();

if (input == null) break;

if (input.startsWith("//")) continue;

if (input.equals("")) continue;

tokenizer = new StringTokenizer(input);

int numtokens = tokenizer.countTokens();

if (numtokens != numAttributes) {

System.err.println( "Read " + root.data.size() + " data");

System.err.println( "Last line read: " + input);

System.err.println( "Expecting " + numAttributes + " attributes");

return 0;

}

DataPoint point = new DataPoint(numAttributes);

for (int i=0; i < numAttributes; i++) {

point.attributes = getSymbolValue(i, tokenizer.nextToken()

);

}

root.data.addElement(point);

}

bin.close();

return 1;

}



public void printTree(TreeNode node, String tab) {

int outputattr = numAttributes-1;

if (node.children == null) {

int []values = getAllValues(node.data, outputattr );

if (values.length == 1) {

System.out.println(tab + "\t" + attributeNames[outputattr] + " = \"" +

domains[outputattr].elementAt(values[0]) + "\";");

return;

}

System.out.print(tab + "\t" + attributeNames[outputattr] + " = {");

for (int i=0; i < values.length; i++) {

System.out.print("\"" + domains[outputattr].elementAt(values) + "\"

");

if ( i != values.length-1 ) System.out.print( " , " );

}

System.out.println( " };");

return;

}

int numvalues = node.children.length;

for (int i=0; i < numvalues; i++) {

System.out.println(tab + "if( " +

attributeNames[node.decompositionAttribute] + " == \"" +

domains[node.decompositionAttribute].elementAt(i)

+ "\") {" );

printTree(node.children, tab + "\t");

if (i != numvalues-1) System.out.print(tab + "} else ");

else System.out.println(tab + "}");

}



}



public void createDecisionTree() {

decomposeNode(root);

printTree(root, "");

}



/* main function */

public static void main(String[] args) throws Exception {







ID3 me = new ID3();

int status = me.readData("c:\\in.txt");

if (status <= 0) return;

me.createDecisionTree();

}



} - See more at: http://www.codemiles.com/java/java-code-for-decision-tree-algorithm-t5747.html#sthash.QocnlaDo.dpuf