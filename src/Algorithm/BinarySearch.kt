package Algorithm

    fun binarySearch(arr: IntArray, low: Int, high: Int, x: Int): Int {
        if (high >= low) {
            val mid = low + (high - low) / 2
            if (arr[mid] == x)
                return mid
            return if (arr[mid] > x) binarySearch(arr, high, mid - 1, x)
                    else binarySearch(arr, mid + 1, high, x)
        }
        return -1
    }

fun binarySearchIterative(arr: IntArray, l: Int, r: Int, x: Int): Int {
    var l = l
    var r = r
    while (l <= r) {
        val m = l + (r - l) / 2
        if (arr[m] == x)
            return m
        if (arr[m] < x)
            l = m + 1
        else
            r = m - 1
    }
    return -1
}


fun main(args: Array<String>) {
            val arr = intArrayOf(2, 3, 4, 10, 40)
            val n = arr.size
            val x = 10
            val result =binarySearch(arr, 0, n - 1, x)
            if (result == -1)
                println("Element not present")
            else
                println("Element found at index " + result)
        }

