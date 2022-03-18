package com.myooo.myooo.practice.binarytree;

/**
 * 剑指offer 26. 树的子结构
 * leetcode 26. 树的子结构
 * medieum
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/submissions/
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return judge(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right,B);
    }
    public boolean judge(TreeNode A, TreeNode B) {
        // B为null 意味着，递归中 A== null 为fasle 并且 (A.value == B.value)都通过了，
        // 并且 跟节点的B.left 或者B.right都遍历完了。
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return (A.value == B.value) && (judge(A.left,B.left)) && (judge(A.right,B.right));
    }
}
