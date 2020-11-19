/**
 * 题目：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 例子：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * @param {TreeNode} root
 * @return {number}
 */

var minDepth = function(root) {
    if(!root){
        return 0
    }
    let queue = []
    queue.push(root)
    let deep = 1
    while(queue.length > 0) {
        /** 这里广度优先，需要把当前层次的所有节点遍历 */
        let len = queue.length
        while(len--) {
            let current = queue.shift()
            let currentLeft = current.left
            let currentRight = current.right
            /** 左右子树都不存在，说明是叶子节点，则返回深度 */
            if(!currentLeft && !currentRight) {
                return deep
            }
            if(currentLeft) {
                queue.push(currentLeft)
            }
            if(currentRight) {
                queue.push(currentRight)
            }
        }
        deep++
    }
    return deep
};
