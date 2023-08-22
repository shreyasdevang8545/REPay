package com.example.repay.security


class HexUtil {
    /**
     * This method is used to convert string in to hex format
     *
     * @param s
     * @return byte[]
     */
    fun HexfromString(s: String): ByteArray {
        val i = s.length
        val abyte0 = ByteArray((i + 1) / 2)
        var j = 0
        var k = 0
        if (i % 2 == 1) abyte0[k++] = HexfromDigit(s[j++]).toByte()
        while (j < i) abyte0[k++] = (HexfromDigit(s[j++]) shl 4 or HexfromDigit(s[j++])).toByte()
        return abyte0
    }

    /**
     * This method is used to return Hex form Digit
     *
     * @param c
     * @return int
     */
    fun HexfromDigit(c: Char): Int {
        if (c >= '0' && c <= '9') return c.code - 48
        if (c >= 'A' && c <= 'F') return c.code - 65 + 10
        return if (c >= 'a' && c <= 'f') c.code - 97 + 10 else throw IllegalArgumentException(
            "invalid hex digit: $c"
        )
    }

    /**
     * This method is used to return string as Hex
     *
     * @param buf
     * @return String
     */
    fun asHex(buf: ByteArray): String {
        val strbuf = StringBuffer(buf.size * 2)
        for (i in buf.indices) {
            if (buf[i].toInt() and 0xff < 16) strbuf.append("0")
            strbuf.append(java.lang.Long.toString((buf[i].toInt() and 0xff).toLong(), 16))
        }
        return strbuf.toString()
    }
    /**
     * This method is used to convert Hex to string
     *
     * @param abyte0
     * @param i
     * @param j
     * @return String
     */
    /**
     * This method is used to convert Hex to string
     *
     * @param abyte0
     * @return String
     */
    @JvmOverloads
    fun HextoString(abyte0: ByteArray, i: Int = 0, j: Int = abyte0.size): String {
        val ac = CharArray(j * 2)
        var k = 0
        for (l in i until i + j) {
            val byte0 = abyte0[l]
            ac[k++] = hexDigits[byte0.toInt() ushr 4 and 0xf]
            ac[k++] = hexDigits[byte0.toInt() and 0xf]
        }
        return String(ac)
    }

    private val hexDigits =
        charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
}
