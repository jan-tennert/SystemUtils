package de.jan.systemutils

import oshi.SystemInfo
import oshi.hardware.GlobalMemory


class Memory(private val si: SystemInfo) {

    fun getFreeMemory() : StorageUnit {
        return StorageUnit(si.hardware.memory.available.toDouble())
    }

    fun getUsedMemory() : StorageUnit {
        return StorageUnit(si.hardware.memory.total - si.hardware.memory.available.toDouble())
    }

    fun getTotalMemory() : StorageUnit {
        return StorageUnit(si.hardware.memory.total.toDouble())
    }

    fun getFreePercent() : Double {
        return Utils.calculatePercentage(getFreeMemory().bytes, getTotalMemory().bytes)
    }

    fun getUsedPercent() : Double {
        return Utils.calculatePercentage(getUsedMemory().bytes, getTotalMemory().bytes)
    }

    fun getMemory() : GlobalMemory {
        return si.hardware.memory
    }

}