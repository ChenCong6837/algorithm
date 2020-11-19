/**
 * 题目： https://leetcode-cn.com/problems/open-the-lock/
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 例子：
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * @param {string[]} deadends
 * @param {string} target
 * @return {number}
 */

/** BFS图的广度优先 */
var openLock = function (deadends, target) {
    let queue = []
    let visited = new Set()
    /** 从起点开始启动广度优先搜索 */
    queue.push('0000')
    visited.add('0000')
    let step = 0

    while (queue.length > 0) {
        let currentLength = queue.length
        /* 将当前队列中的所有节点向周围扩散 */
        while (currentLength--) {
            let current = queue.shift()
            /** 需要跳过的死亡密码 */
            if (deadends.indexOf(current) !== -1) {
                continue
            }
            if (current === target) {
                return step
            }
            /** 4个位置，每个位置的密码有两个方向： 向上一下，或向下一下 */
            for (let i = 0; i < 4; i++) {
                let up = plusOne(current, i)
                /** 将未遍历到的节点加入队列 */
                if (!visited.has(up)) {
                    queue.push(up)
                    visited.add(up)
                }
                let down = minusOne(current, i)
                if (!visited.has(down)) {
                    queue.push(down)
                    visited.add(down)
                }
            }
        }
        step++
    }
    return -1
};

/** 再第j位置加1 */
function plusOne(str, j) {
    let strToNumArr = str.split('').map(i => +i)
    if (strToNumArr[j] === 9) {
        strToNumArr[j] = 0
    } else {
        strToNumArr[j] += 1
    }
    return strToNumArr.join("")
}
/** 再第j位置减1 */
function minusOne(str, j) {
    let strToNumArr = str.split('').map(i => +i)
    if (strToNumArr[j] === 0) {
        strToNumArr[j] = 9
    } else {
        strToNumArr[j] -= 1
    }
    return strToNumArr.join("")
}