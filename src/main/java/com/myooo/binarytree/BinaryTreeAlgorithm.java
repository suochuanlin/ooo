package com.myooo.binarytree;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeAlgorithm {

    public static void main(String[] args) {
//        int[] sourceArray = new int[]{6, 7, 9, 8, 4, 3};
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder =  new int[]{9,3,15,20,7};
//        System.out.println("createBinarySearchTree" + JSONObject.toJSONString(createBinarySearchTree(sourceArray)));
//        System.out.println("insertArr" + JSONObject.toJSONString(insertArr(sourceArray)));
//        System.out.println("insertRecurision" + JSONObject.toJSONString(insertRecurision(sourceArray)));
        System.out.println("reCreateBinaryTree " + JSONObject.toJSONString(reCreateBinaryTree(preorder,inorder)));
    }

    /**
     *  1、根据数组 创建二叉搜索树
     */
    public static TreeNode insertArr(int[] sourceArray) {
        if (sourceArray == null || sourceArray.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(sourceArray[0]);
        for (int i = 1; i < sourceArray.length; i++) {
            insertRecurision(root, sourceArray[i]);
        }

        return root;
    }


    public static TreeNode createBinarySearchTree(int[] sourceArray) {
        if (sourceArray == null || sourceArray.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(sourceArray[0]);
        for (int i = 1; i < sourceArray.length; i++) {
            root = add(root, sourceArray[i]);
        }

        return root;
    }

    //迭代方法
    public static TreeNode add(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null) {
            // insert into the right subtree
            if (val > node.value) {
                // insert right now
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                } else node = node.right;
            }
            // insert into the left subtree
            else {
                // insert right now
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return root;
                } else node = node.left;
            }
        }
        return new TreeNode(val);
    }


    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        TreeNode node = root;

        while (true) {
            if (value > node.value) { //大于节点 操作rigit
                if (node.right == null) {
                    node.right = new TreeNode(value);
                    return root;
                } else {
                    node = node.right;
                }
            } else { //小于节点
                if (node.left == null) {
                    node.left = new TreeNode(value);
                    return root;

                } else {
                    node = node.left;
                }
            }
        }
    }

    //递归
    public static TreeNode insertRecurision(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value > root.value) root.right = insertRecurision(root.right,value);
        if (value < root.value) root.left = insertRecurision(root.left,value);
        return root;
    }

    /**
     * 2、根据前中序 重建二叉树
     * @param args
     */
/*

    二叉树的前序遍历顺序是：根节点、左子树、右子树，每个子树的遍历顺序同样满足前序遍历顺序。

    二叉树的中序遍历顺序是：左子树、根节点、右子树，每个子树的遍历顺序同样满足中序遍历顺序。

    1、前序遍历的第一个节点是根节点，只要找到根节点在中序遍历中的位置，根节点之前被访问的节点都位于左子树，
            在根节点之后被访问的节点都位于右子树，由此可知左子树和右子树分别有多少个节点。

    2、由于树中的节点数量与遍历方式无关，通过中序遍历得知左子树和右子树的节点数量之后，可以根据节点数量得到前序遍历中的左子树和右子树的分界，
        因此可以进一步得到左子树和右子树各自的前序遍历和中序遍历，可以通过递归的方式，重建左子树和右子树，然后重建整个二叉树。

    //以下为实现逻辑
    3、使用一个 Map 存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素在中序遍历中的位置。
            调用递归方法，对于前序遍历和中序遍历，下标范围都是从 0 到 n-1，其中 n 是二叉树节点个数。

    4、递归方法的基准情形有两个：判断前序遍历的下标范围的开始和结束，若开始大于结束，则当前的二叉树中没有节点，返回空值 null。
            若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。

    5、若开始小于结束，则当前的二叉树中有多个节点。在中序遍历中得到根节点的位置，从而得到左子树和右子树各自的下标范围和节点数量，知道节点数量后，
 在前序遍历中即可得到左子树和右子树各自的下标范围，然后递归重建左子树和右子树，并将左右子树的根节点分别作为当前根节点的左右子节点。

     preOrder = {3,9,20,15,7}
     inOrder = {9,3,15,20,7}
 */

    public static Map<Integer, Integer> inIndexMap = new HashMap(16);


    public static TreeNode reCreateBinaryTree(int[] preOrderArray, int[] inOrderArray) {
        int length = inOrderArray.length;
        for (int i = 0; i < length; i++) {
            inIndexMap.put(inOrderArray[i], i); //存中序遍历下标
        }
        //递归拆解中序及前序
        //入参
        return createTree(preOrderArray, 0, length - 1,
                inOrderArray, 0, length - 1, inIndexMap);
    }

    private static TreeNode createTree(int[] preOrderArray, int preStartIndex, int preOrderEndIndex,
                                       int[] inOrderArray, int inStartIndex, int inOrderEndIndex,
                                       Map<Integer, Integer> inIndexMap) {

        if (preStartIndex > preOrderEndIndex) {
            return null; //1、说明子节点为null
        }
        Integer rootIndex = inIndexMap.get(preOrderArray[preStartIndex]); //中序数组中root点index
        int rootVal = preOrderArray[preStartIndex];
        TreeNode root = new TreeNode(rootVal); //前序第一个值为根节点
        if (preStartIndex == preOrderEndIndex) {
            return root; //2、说明只有一个节点
        } else {
            //3、重建左子树
            int leftNodesNum = rootIndex - inStartIndex, rightNodesNum = inOrderEndIndex - rootIndex; //根左右序列长度（节点个数）
            root.left = createTree(preOrderArray, preStartIndex + 1, preStartIndex + leftNodesNum,
                    inOrderArray, inStartIndex, inStartIndex + leftNodesNum + 1,
                    inIndexMap);
            //4、重建右子树
            root.right = createTree(preOrderArray, rootIndex + 1, rootIndex + rightNodesNum,
                    inOrderArray, inStartIndex, inStartIndex + rightNodesNum + 1,
                    inIndexMap);
            return root;
        }
    }


    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

//    public TreeNode reBuildTree(int[] preArray, int s1, int e1, int[] inArray, int s2, int e2) {
//        int rootVal = preArray[s1];
//    }



    /**
     * leetcode 226题、剑指offer 27题
     * 翻转一棵二叉树
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //根节点的 非空子节点进行交换，一直递归到最后null节点
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode rightNode = invertTree(root.right);
        TreeNode leftNode = invertTree(root.left);
        root.left= rightNode;
        root.right = leftNode;
        return root;
    }


}
