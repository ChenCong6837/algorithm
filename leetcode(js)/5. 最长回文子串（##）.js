/**
 * 题目： https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 */


/** 暴力解法 */
var longestPalindrome = function (s) {
    if (!s) {
        return
    }
    if (s.length === 1) {
        return s
    }
    /** 判断一个字符串是否是回文串 */
    // function isPalindrome(s) {
    //     const len = s.length
    //     if (len === 1) {
    //         return true
    //     }
    //     if (len === 2 && s[0] === s[1]) {
    //         return true
    //     }
    //     return s[0] === s[len - 1] && isPalindrome(s.substring(1, len - 1))
    // }
    function isPalindrome(s) {
        let left = 0
        let right = s.length - 1
        while (left < right) {
            if (s[left] !== s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }

    /** 包含首字符的最大回文串 */
    function findMax(s) {
        let tmpMax = s[0]
        for (let i = s.length; i > 0; i--) {
            let curStr = s.substring(0, i)
            if (isPalindrome(curStr)) {
                tmpMax = curStr
                break
            }
        }
        return tmpMax
    }
    let maxPalindrome = s[0]
    /** 遍历一遍 */
    for (let i = 0; i < s.length; i++) {
        /** 当前的最大回文子串如果已经大于剩下的子串的长度，则直接返回 */
        if (maxPalindrome.length > s.length - i) {
            return maxPalindrome
        }
        let curMax = findMax(s.substring(i, s.length))
        if (curMax.length > maxPalindrome.length) {
            maxPalindrome = curMax
        }
    }

    return maxPalindrome
};

console.log('longestPalindrome', longestPalindrome('asdasasdassssdasddasdasdascsaasdasasasasasdasdasdasdascbabcd'))