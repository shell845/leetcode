package main.java.leetcodemainset;

import java.util.*;

/**
 * @author YC 04/02/2020
 */

public class _297_SerializeDeserializeBinaryTree {
    // Definition for a binary tree node.
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

   /** Note: - negative node val
    *        - repeated node val
    *        - Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
    */

   /** Complexity O(n), space O(n) */
   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
       if (root == null) return null;
       StringBuilder sb = new StringBuilder();
       preOrder(root, sb);
       System.out.println(sb.toString()); // test
       return sb.toString();
   }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] s = data.split(";");
        Queue<String> queue = new LinkedList<>(Arrays.asList(s));
        System.out.println(Arrays.toString(s)); // test
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
       if (queue.isEmpty()) return null;
       String s = queue.remove();
       if (!s.equals("*")) {
           TreeNode node = new TreeNode(Integer.parseInt(s));
           node.left = buildTree(queue);
           node.right = buildTree(queue);
           return node;
       } else return null;
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("*;");
            return;
        }
        sb.append(node.val + ";"); // separator, note integer may be negative
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }


    /** Below solution works for tress with no repeat value nodes only
    * Use pre-order & in-order to build tree */
    /*// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        inOrder(root, sb);
        System.out.println(sb.toString()); // test
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        // convert string to integer list, note integer may be negative
        String[] s = data.split(";");
        ArrayList<Integer> nums = new ArrayList<>();
        for (String i:s) {
            nums.add(Integer.parseInt(i));
        }
        // build tree
        int len = nums.size();
        int preL = 0, preR = len / 2 - 1, inL = len / 2, inR = len - 1;
        return buildTree(nums, preL, preR, inL, inR, len);
    }

    private TreeNode buildTree(ArrayList<Integer> nums, int preL, int preR, int inL, int inR, int len) {
        if (preL < 0 || preR > len / 2 - 1 || preL > preR || inL < len / 2 || inR > len - 1 || inL > inR) return null;
        TreeNode root = new TreeNode(nums.get(preL));
        int count = nums.lastIndexOf(nums.get(preL)) - inL;
        root.left = buildTree(nums, preL + 1, preL + count, inL, inL + count - 1, len);
        root.right = buildTree(nums, preL + count + 1, preR, inL + count + 1, inR, len);
        return root;
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val);
        sb.append(";"); // separator, note integer may be negative
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        inOrder(node.left, sb);
        sb.append(node.val);
        sb.append(";"); // separator, note integer may be negative
        inOrder(node.right, sb);
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        _297_SerializeDeserializeBinaryTree test = new _297_SerializeDeserializeBinaryTree();
        String s = test.serialize(root);
        test.deserialize(s);
    }
}
