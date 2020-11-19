/**
 * 题目： https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 *
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 * 例子：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 *
 * @param {number} R
 * @param {number} C
 * @param {number} r0
 * @param {number} c0
 * @return {number[][]}
 *
 */

function allCellsDistOrder(R, C, r0, c0) {
    /** 获取距离目标点最大距离X（则距离的范围即为： [0, X]） */
    function getMaxDistance(R, C, r0, c0) {
        return Math.max(
            distance(R - 1, C - 1, r0, c0),
            distance(0, 0, r0, c0),
            distance(R - 1, 0, r0, c0),
            distance(0, C - 1, r0, c0)

        )
    }
    /** 计算两点间的曼哈顿距离 */
    function distance(r1, c1, r2, c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2)
    }
    let maxDistance = getMaxDistance(R, C, r0, c0)
    /** 创建二维数组，一维数组的下标即为距离，相同距离的点放在同样下标的数组中 */
    let res = new Array(maxDistance)
    for(let i = 0; i <= maxDistance; i++) {
        res[i] = []
    }
    /** 遍历所有节点，计算距离，然后放到对应下标的数组中即可（类似桶排序） */
    for (let i = 0; i < R; i++) {
        for (let j = 0; j < C; j++) {
            let distance = Math.abs(i - r0) + Math.abs(j - c0)
            res[distance].push([i, j])
        }
    }
    /** 把二维数组展开为一维返回 */
    return res.flat(1)
};