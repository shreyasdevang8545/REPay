package com.example.repay.security


class Base64util {
    /**
     * Encode some data and return a String.
     */
    fun encode(d: ByteArray?): String? {
        if (d == null) return null
        val data = ByteArray(d.size + 2)
        System.arraycopy(d, 0, data, 0, d.size)
        val dest = ByteArray(data.size / 3 * 4)

        // 3-byte to 4-byte conversion
        var sidx = 0
        var didx = 0
        while (sidx < d.size) {
            dest[didx] = (data[sidx].toInt() ushr 2 and 63).toByte()
            dest[didx + 1] =
                (data[sidx + 1].toInt() ushr 4 and 15 or (data[sidx].toInt() shl 4 and 63)).toByte()
            dest[didx + 2] =
                (data[sidx + 2].toInt() ushr 6 and 3 or (data[sidx + 1].toInt() shl 2 and 63)).toByte()
            dest[didx + 3] = (data[sidx + 2].toInt() and 63).toByte()
            sidx += 3
            didx += 4
        }

        // 0-63 to ascii printable conversion
        for (idx in dest.indices) {
            if (dest[idx] < 26) dest[idx] =
                (dest[idx] + 'A'.code.toByte()).toByte() else if (dest[idx] < 52) dest[idx] =
                (dest[idx] + 'a'.code.toByte() - 26).toByte() else if (dest[idx] < 62) dest[idx] =
                (dest[idx] + '0'.code.toByte() - 52).toByte() else if (dest[idx] < 63) dest[idx] =
                '+'.code.toByte() else dest[idx] = '/'.code.toByte()
        }

        // add padding
        for (idx in dest.size - 1 downTo d.size * 4 / 3 + 1) {
            dest[idx] = '='.code.toByte()
        }
        return String(dest)
    }

    /**
     * Encode a String using Base64 using the default platform encoding
     */
    fun encode(s: String): String? {
        return encode(s.toByteArray())
    }

    /**
     * Decode data and return bytes.
     */
    fun decode(str: String?): ByteArray? {
        if (str == null) return null
        val data = str.toByteArray()
        return decode(data)
    }

    /**
     * Decode data and return bytes. Assumes that the data passed in is ASCII
     * text.
     */
    fun decode(data: ByteArray): ByteArray {
        var tail = data.size
        while (data[tail - 1] == '='.code.toByte()) tail--
        val dest = ByteArray(tail - data.size / 4)

        // ascii printable to 0-63 conversion
        for (idx in data.indices) {
            if (data[idx] == '='.code.toByte()) data[idx] =
                0 else if (data[idx] == '/'.code.toByte()) data[idx] =
                63 else if (data[idx] == '+'.code.toByte()) data[idx] =
                62 else if (data[idx] >= '0'.code.toByte() && data[idx] <= '9'.code.toByte()) data[idx] =
                (data[idx] - ('0'.code - 52)).toByte() else if (data[idx] >= 'a'.code.toByte() && data[idx] <= 'z'.code.toByte()) data[idx] =
                (data[idx] - ('a'.code - 26)).toByte() else if (data[idx] >= 'A'.code.toByte() && data[idx] <= 'Z'.code.toByte()) data[idx] =
                (data[idx] - 'A'.code.toByte()).toByte()
        }

        // 4-byte to 3-byte conversion
        var sidx: Int
        var didx: Int
        sidx = 0
        didx = 0
        while (didx < dest.size - 2) {
            dest[didx] =
                (data[sidx].toInt() shl 2 and 255 or (data[sidx + 1].toInt() ushr 4 and 3)).toByte()
            dest[didx + 1] =
                (data[sidx + 1].toInt() shl 4 and 255 or (data[sidx + 2].toInt() ushr 2 and 15)).toByte()
            dest[didx + 2] =
                (data[sidx + 2].toInt() shl 6 and 255 or (data[sidx + 3].toInt() and 63)).toByte()
            sidx += 4
            didx += 3
        }
        if (didx < dest.size) {
            dest[didx] =
                (data[sidx].toInt() shl 2 and 255 or (data[sidx + 1].toInt() ushr 4 and 3)).toByte()
        }
        if (++didx < dest.size) {
            dest[didx] =
                (data[sidx + 1].toInt() shl 4 and 255 or (data[sidx + 2].toInt() ushr 2 and 15)).toByte()
        }
        return dest
    }
}
