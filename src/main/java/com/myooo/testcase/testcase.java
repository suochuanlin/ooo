package com.myooo.testcase;

import com.alibaba.fastjson.JSONObject;
import com.myooo.binarytree.BinaryTreeAlgorithm;
import com.myooo.binarytree.TreeNode;

public class testcase {
    public static void main(String[] args) {
        BinaryTreeAlgorithm binaryTreeAlgorithm = new BinaryTreeAlgorithm();
        int[] array = new int[] {4,7,2,6,9,3,1};
        TreeNode root = BinaryTreeAlgorithm.createBinarySearchTree(array);
        TreeNode a = binaryTreeAlgorithm.invertTree(root);
        System.out.println(JSONObject.toJSONString(a));

    }
}
