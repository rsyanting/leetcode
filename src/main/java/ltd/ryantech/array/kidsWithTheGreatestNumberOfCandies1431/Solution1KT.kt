package ltd.ryantech.array.kidsWithTheGreatestNumberOfCandies1431

/**
 * @author jerry
 * @program leetcode
 * @package_name ltd.ryantech.array.kidsWithTheGreatestNumberOfCandies1431
 * @description 拥有最多糖果的孩子
 * @leetcode_CN_url // https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 * @leetcode_US_url // https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * @hard_level Easy
 * @tag Array // https://leetcode-cn.com/tag/array/
 * @create 2020/06/01 14:48
 **/

fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
    var maxCandies: Int = Int.MIN_VALUE
    for (num: Int in candies) {
        maxCandies = num.coerceAtLeast(maxCandies)
    }
    val res = BooleanArray(candies.size)
    for (idx: Int in candies.indices) {
        res[idx] = candies[idx] + extraCandies >= maxCandies
    }
    return res
}

fun main(args: Array<String>) {
    val candies: IntArray = intArrayOf(2, 3, 5, 1, 3)
    val extraCandies: Int = 3
    val res: BooleanArray = kidsWithCandies(candies, extraCandies)
    for (i: Boolean in res) {
        println(i)
    }
}