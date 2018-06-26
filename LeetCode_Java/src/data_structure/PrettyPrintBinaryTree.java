package data_structure;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class PrettyPrintBinaryTree {

    private static int getMaximumHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = getMaximumHeight(node.left);
        int rightHeight = getMaximumHeight(node.right);
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }

    private static String multiplyString(String string, int times) {
        StringBuilder builder = new StringBuilder(string.length() * times);
        for (int i = 0; i < times; ++i) {
            builder.append(string);
        }
        return builder.toString();
    }

    public static String getStartingSpace(int height) {
        return multiplyString("  ", ((int) Math.pow(2, height - 1)) / 2);
    }

    public static String getUnderScores(int height) {
        int noOfElementsToLeft = ((int) Math.pow(2, height) - 1) / 2;
        int noOfUnderScores = noOfElementsToLeft
                - ((int) Math.pow(2, height - 1) / 2);

        return multiplyString("__", noOfUnderScores);
    }

    public static String getSpaceBetweenTwoNodes(int height) {
        if (height == 0)
            return "";

        int noOfNodesInSubTreeOfNode = ((int) Math.pow(2, height - 1)) / 2;
        /** Sum of spaces of the subtrees of nodes + the parent node */
        int noOfSpacesBetweenTwoNodes = noOfNodesInSubTreeOfNode * 2 + 1;

        return multiplyString("  ", noOfSpacesBetweenTwoNodes);
    }

    public static void printNodes(List<TreeNode> queueOfNodes,
                                  int noOfNodesAtCurrentHeight, int height) {
        StringBuilder nodesAtHeight = new StringBuilder();

        String startSpace = getStartingSpace(height);
        String spaceBetweenTwoNodes = getSpaceBetweenTwoNodes(height);

        String underScore = getUnderScores(height);
        String underScoreSpace = multiplyString(" ", underScore.length());

        nodesAtHeight.append(startSpace);
        for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
            TreeNode node = (TreeNode) queueOfNodes.get(i);
            if (node == null) {
                nodesAtHeight.append(underScoreSpace)
                        .append("  ")
                        .append(underScoreSpace)
                        .append(spaceBetweenTwoNodes);
            } else {
                nodesAtHeight
                        .append(node.left != null ? underScore
                                : underScoreSpace)
                        .append(String.format("%2d", node.val))
                        .append(node.right != null ? underScore
                                : underScoreSpace)
                        .append(spaceBetweenTwoNodes);
            }
        }

        System.out.println(nodesAtHeight.toString().replaceFirst("\\s+$", ""));
    }

    public static String getSpaceBetweenLeftRightBranch(int height) {
        int noOfNodesBetweenLeftRightBranch = ((int) Math.pow(2, height - 1) - 1);

        return multiplyString("  ", noOfNodesBetweenLeftRightBranch);
    }

    public static String getSpaceBetweenRightLeftBranch(int height) {
        int noOfNodesBetweenLeftRightBranch = (int) Math.pow(2, height - 1);

        return multiplyString("  ", noOfNodesBetweenLeftRightBranch);
    }

    public static void printBranches(List<TreeNode> queueOfNodes,
                                     int noOfNodesAtCurrentHeight, int height) {
        if (height <= 1)
            return;
        StringBuilder brachesAtHeight = new StringBuilder();

        String startSpace = getStartingSpace(height);
        String leftRightSpace = getSpaceBetweenLeftRightBranch(height);
        String rightLeftSpace = getSpaceBetweenRightLeftBranch(height);

        brachesAtHeight
                .append(startSpace.substring(0, startSpace.length() - 1));

        for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
            TreeNode node = queueOfNodes.get(i);
            if (node == null) {
                brachesAtHeight.append(" ")
                        .append(leftRightSpace)
                        .append(" ")
                        .append(rightLeftSpace);
            } else {
                brachesAtHeight.append(node.left != null ? "/" : " ")
                        .append(leftRightSpace)
                        .append(node.right != null ? "\\" : " ")
                        .append(rightLeftSpace);
            }
        }

        System.out
                .println(brachesAtHeight.toString().replaceFirst("\\s+$", ""));
    }

    public static void print(TreeNode root) {
        LinkedList<TreeNode> queueOfNodes = new LinkedList<>();
        int height = getMaximumHeight(root);
        int level = 0;
        int noOfNodesAtCurrentHeight = 0;

        queueOfNodes.add(root);

        while (!queueOfNodes.isEmpty() && level < height) {
            noOfNodesAtCurrentHeight = ((int) Math.pow(2, level));

            printNodes(queueOfNodes, noOfNodesAtCurrentHeight, height - level);
            printBranches(queueOfNodes, noOfNodesAtCurrentHeight, height
                    - level);

            for (int i = 0; i < noOfNodesAtCurrentHeight; i++) {
                TreeNode currNode = queueOfNodes.peek();
                queueOfNodes.remove();
                if (currNode != null) {
                    queueOfNodes.add(currNode.left);
                    queueOfNodes.add(currNode.right);
                } else {
                    queueOfNodes.add(null);
                    queueOfNodes.add(null);
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(80, 30, 90, 20, 100, 99, 40, 10, 25, 35, 50, 5, 15, 23, 28, 33, 38, 41, 55);
        TreeNode root = TreeUtil.createTree(array);
        PrettyPrintBinaryTree.print(root);
    }
}

class TreeUtil {

    public static TreeNode createTree(List<Integer> list) {
        TreeNode root = null;
        TreeNode temp, temp2;
        for (Integer integer : list) {
            if (root == null) {
                root = new TreeNode(integer);
                root.left = null;
                root.right = null;
                continue;
            }
            temp = root;
            temp2 = root;
            while (temp != null) {
                temp2 = temp;
                temp = (temp.val < integer) ? temp.right : temp.left;
            }

            if (temp2.val < integer) {
                temp2.right = new TreeNode(integer);
            } else {
                temp2.left = new TreeNode(integer);
            }
        }

        return root;
    }
}
//
//
//class TreeNode {
//    TreeNode left;
//    TreeNode right;
//    int val;
//    TreeNode(int val) {
//        this.val = val;
//    }
//}
