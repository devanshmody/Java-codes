

import java.io.*;

class DecisionTree {

    
    private class BinTree {

	/* FIELDS */

	private int     nodeID;
    	private String  questOrAns = null;
    	private BinTree yesBranch  = null;
    	private BinTree noBranch   = null;

	/* CONSTRUCTOR */

	public BinTree(int newNodeID, String newQuestAns) {
	    nodeID     = newNodeID;
	    questOrAns = newQuestAns;
            }
	}

    /* OTHER FIELDS */

    static BufferedReader    keyboardInput = new BufferedReader(new InputStreamReader(System.in));
    BinTree rootNode = null;

   
    /* Default Constructor */

    public DecisionTree() {
	}

     /* CREATE ROOT NODE */

    public void createRoot(int newNodeID, String newQuestAns) {
	rootNode = new BinTree(newNodeID,newQuestAns);
	System.out.println("Created root node " + newNodeID);
	}

    /* ADD YES NODE */

    public void addYesNode(int existingNodeID, int newNodeID, String newQuestAns) {
	// If no root node do nothing

	if (rootNode == null) {
	    System.out.println("ERROR: No root node!");
	    return;
	    }

	// Search tree

	if (searchTreeAndAddYesNode(rootNode,existingNodeID,newNodeID,newQuestAns)) {
	    System.out.println("Added node " + newNodeID +
	    		" onto \"yes\" branch of node " + existingNodeID);
	    }
	else System.out.println("Node " + existingNodeID + " not found");
	}

    /* SEARCH TREE AND ADD YES NODE */

    private boolean searchTreeAndAddYesNode(BinTree currentNode,
    			int existingNodeID, int newNodeID, String newQuestAns) {
    	if (currentNode.nodeID == existingNodeID) {
	    // Found node
	    if (currentNode.yesBranch == null) currentNode.yesBranch = new
	    		BinTree(newNodeID,newQuestAns);
	    else {
	        System.out.println("WARNING: Overwriting previous node " +
			"(id = " + currentNode.yesBranch.nodeID +
			") linked to yes branch of node " +
			existingNodeID);
		currentNode.yesBranch = new BinTree(newNodeID,newQuestAns);
		}
    	    return(true);
	    }
	else {
	    // Try yes branch if it exists
	    if (currentNode.yesBranch != null) {
	        if (searchTreeAndAddYesNode(currentNode.yesBranch,
		        	existingNodeID,newNodeID,newQuestAns)) {
	            return(true);
		    }
		else {
    	        // Try no branch if it exists
	    	    if (currentNode.noBranch != null) {
    	    		return(searchTreeAndAddYesNode(currentNode.noBranch,
				existingNodeID,newNodeID,newQuestAns));
			}
		    else return(false);	// Not found here
		    }
    		}
	    return(false);		// Not found here
	    }
   	}

    /* ADD NO NODE */

    public void addNoNode(int existingNodeID, int newNodeID, String newQuestAns) {
	// If no root node do nothing

	if (rootNode == null) {
	    System.out.println("ERROR: No root node!");
	    return;
	    }

	// Search tree

	if (searchTreeAndAddNoNode(rootNode,existingNodeID,newNodeID,newQuestAns)) {
	    System.out.println("Added node " + newNodeID +
	    		" onto \"no\" branch of node " + existingNodeID);
	    }
	else System.out.println("Node " + existingNodeID + " not found");
	}

    /* SEARCH TREE AND ADD NO NODE */

    private boolean searchTreeAndAddNoNode(BinTree currentNode,
    			int existingNodeID, int newNodeID, String newQuestAns) {
    	if (currentNode.nodeID == existingNodeID) {
	    // Found node
	    if (currentNode.noBranch == null) currentNode.noBranch = new
	    		BinTree(newNodeID,newQuestAns);
	    else {
	        System.out.println("WARNING: Overwriting previous node " +
			"(id = " + currentNode.noBranch.nodeID +
			") linked to yes branch of node " +
			existingNodeID);
		currentNode.noBranch = new BinTree(newNodeID,newQuestAns);
		}
    	    return(true);
	    }
	else {
	    // Try yes branch if it exists
	    if (currentNode.yesBranch != null) {
	        if (searchTreeAndAddNoNode(currentNode.yesBranch,
		        	existingNodeID,newNodeID,newQuestAns)) {
	            return(true);
		    }
		else {
    	        // Try no branch if it exists
	    	    if (currentNode.noBranch != null) {
    	    		return(searchTreeAndAddNoNode(currentNode.noBranch,
				existingNodeID,newNodeID,newQuestAns));
			}
		    else return(false);	// Not found here
		    }
		 }
	    else return(false);	// Not found here
	    }
   	}

    

    public void queryBinTree() throws IOException {
        queryBinTree(rootNode);
        }

    private void queryBinTree(BinTree currentNode) throws IOException {

        // Test for leaf node (answer) and missing branches

        if (currentNode.yesBranch==null) {
            if (currentNode.noBranch==null) System.out.println(currentNode.questOrAns);
            else System.out.println("Error: Missing \"Yes\" branch at \"" +
            		currentNode.questOrAns + "\" question");
            return;
            }
        if (currentNode.noBranch==null) {
            System.out.println("Error: Missing \"No\" branch at \"" +
            		currentNode.questOrAns + "\" question");
            return;
            }

        // Question

        askQuestion(currentNode);
        }

    private void askQuestion(BinTree currentNode) throws IOException {
        System.out.println(currentNode.questOrAns + " (enter \"Yes\" or \"No\")");
        String answer = keyboardInput.readLine();
        if (answer.equals("Yes")) queryBinTree(currentNode.yesBranch);
        else {
            if (answer.equals("No")) queryBinTree(currentNode.noBranch);
            else {
                System.out.println("ERROR: Must answer \"Yes\" or \"No\"");
                askQuestion(currentNode);
                }
            }
        }

    
    /* OUTPUT BIN TREE */

    public void outputBinTree() {

        outputBinTree("1",rootNode);
        }

    private void outputBinTree(String tag, BinTree currentNode) {

        // Check for empty node

        if (currentNode == null) return;

        // Output

        System.out.println("[" + tag + "] nodeID = " + currentNode.nodeID +
        		", question/answer = " + currentNode.questOrAns);

        // Go down yes branch

        outputBinTree(tag + ".1",currentNode.yesBranch);

        // Go down no branch

        outputBinTree(tag + ".2",currentNode.noBranch);
	}
    }


