package leetcodemainset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YC 03/17/2020
 */

public class _95_GenerateTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        return genTree(1, n);
    }

    private List<TreeNode> genTree(int first, int last) {
        List<TreeNode> list = new ArrayList<>();

        if (first > last) {
            list.add(null);
            return list;
        }

        for (int i = first; i <= last; i++) {
            List<TreeNode> leftList = genTree(first, i - 1);
            List<TreeNode> rightList = genTree(i + 1, last);

            for (int j = 0; j < leftList.size(); j++) {
                TreeNode left = leftList.get(j);
                for (int l = 0; l < rightList.size(); l++) {
                    TreeNode right = rightList.get(l);
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        _95_GenerateTrees gt = new _95_GenerateTrees();
        List<TreeNode> list = gt.generateTrees(3);
        for (TreeNode t:list) {
            System.out.println(t.val);
        }
    }
}
