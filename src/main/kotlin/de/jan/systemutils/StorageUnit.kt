package de.jan.systemutils

class StorageUnit(val bytes: Double) {

    fun toKilobyte() : Double {
        return bytes / 1000.toDouble()
    }

    fun toMegabyte() : Double {
        return bytes / 1000000.toDouble()
    }

    fun toGigabyte() : Double {
        return bytes / 1000000000.toDouble()
    }

}