/**
 * 题目：https://leetcode-cn.com/problems/super-egg-drop/
 *
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 * 你的目标是确切地知道 F 的值是多少。
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 * 例子：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 *
 * @param {number} K
 * @param {number} N
 * @return {number}
 */


/** 还没用备忘录，提交会超时 */
function superEggDrop(K, N) {
    function dp(subK, subN) {
        /** 鸡蛋只有1个，那重下往上，最少也要subN次；
         *  只有1层楼，那也只需1次
         */
        if (subK === 1) {
            return subN
        }
        if (subN === 0 || subN === 1) {
            return subN
        }
        // let min = Math.floor(Math.sqrt(subN)) + 1
        // /** 鸡蛋个数比较多，那直接2分法查找 */
        // if(subK >= min) {
        //     return min
        // }
        // /** 一分为二，获取中间的楼层 */
        // let midFloor = Math.ceil(subN / 2)
        // /** 分两种情况：1.蛋碎了；2.蛋没碎 */
        // return Math.max(dp(subK - 1, midFloor - 1), dp(subK, subN - midFloor)) + 1

        let min = subN
        for (let i = 1; i < subN; i++) {
            min = Math.min(Math.max(dp(subK - 1, i - 1), dp(subK, subN - i)) + 1, min)
        }
        return min
    }
    return dp(K, N)
};

console.log('superEggDrop(2, 1)', superEggDrop(2, 1)) // 1
console.log('superEggDrop(1, 2)', superEggDrop(1, 2)) // 2
console.log('superEggDrop(2, 4)', superEggDrop(2, 4)) //  3
console.log('superEggDrop(2, 6)', superEggDrop(2, 6)) //  3
console.log('superEggDrop(3, 14)', superEggDrop(3, 14)) //  4
console.log('superEggDrop(2, 9)', superEggDrop(2, 9)) //  4
console.log('superEggDrop(3, 41)', superEggDrop(3, 41)) //  4