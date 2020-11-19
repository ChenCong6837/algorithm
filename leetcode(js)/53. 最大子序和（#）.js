/**
 * 题目：https://leetcode-cn.com/problems/maximum-subarray/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 例子：
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */


 /** 暴力解法，时间超出限制 */
 function maxSubArray1(nums) {
    if(nums.length === 1) {
        return nums[0]
    }
    function dp(bit) {
        const subRes = []
        for(let i = 0; i <= nums.length - bit; i++) {
            let tmp = 0
            for(let j = i; j < i + bit; j++){
                tmp += nums[j]
            }
            subRes.push(tmp)
        }
        return Math.max(...subRes)
    }
    let max = -Infinity
    for(let i = 1; i <= nums.length; i++) {
        max = Math.max(dp(i), max)
    }
    return max
};


/**
 * 状态转移方程：sum[i] = max{sum[i-1]+a[i],a[i]}
 */
 function maxSubArray(nums) {
    let res = nums[0]
    let sum = 0
    for(let num of nums) {
        sum = Math.max(sum + num, num)
        res = Math.max(res, sum)
    }
    return res
};




console.log('maxSubArray([-2,1,-3,4,-1,2,1,-5,4])', maxSubArray([-2,1,-3,4,-1,2,1,-5,4])) // 6
console.log('maxSubArray([-2,-1,-3,-4,-1,-2,-1,-5,-4])', maxSubArray([-2,-1,-3,-4,-1,-2,-1,-5,-4])) // -1
console.log('maxSubArray([-2,1])', maxSubArray([-2,1]))  // 1
console.log('maxSubArray([2,1])', maxSubArray([2,1]))  // 3