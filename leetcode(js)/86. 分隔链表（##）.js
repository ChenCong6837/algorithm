/**
 * 题目：https://leetcode-cn.com/problems/partition-list/
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 例子：
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */

var partition = function (head, x) {
    /** 1. 自己写的 */
    // const originalHead = new ListNode(Number.POSITIVE_INFINITY)
    // originalHead.next = head
    // head = originalHead
    // let nodeQueue = []
    // while(head.next){
    //     if(head.next.val < x) {
    //         nodeQueue.push(head.next)
    //         head.next = head.next.next
    //     } else {
    //         head = head.next
    //     }
    // }
    // head = originalHead
    // if(!head.next) {
    //     while(nodeQueue.length > 0) {
    //         const currentNode = nodeQueue.shift()
    //         currentNode.next = head.next
    //         head.next = currentNode
    //         head = head.next
    //     }
    //     return originalHead.next
    // }
    // head = originalHead
    // while(nodeQueue.length > 0) {
    //     const currentNode = nodeQueue.shift()
    //     while(head) {
    //         if(head.val <= currentNode.val || (head.next && head.next.val > currentNode.val) ) {
    //             currentNode.next = head.next
    //             head.next = currentNode
    //             head = currentNode
    //             break
    //         } else {
    //             head = head.next
    //         }
    //     }
    // }
    // return originalHead.next

    /** 2. 将链表分为两段，前面一段小于x，后面一段大于等于x，然后将两个表连接即可 */
    const before_head = new ListNode(null)
    let before = before_head
    const after_head = new ListNode(null)
    let after = after_head
    while (head) {
        if (head.val < x) {
            before.next = head
            before = before.next
        } else {
            after.next = head
            after = after.next
        }
        head = head.next
    }
    after.next = null;
    before.next = after_head.next
    return before_head.next
};