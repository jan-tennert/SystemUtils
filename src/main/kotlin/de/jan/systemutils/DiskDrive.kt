package de.jan.systemutils

import oshi.SystemInfo
import oshi.software.os.OSFileStore


class DiskDrive(private val fs: OSFileStore) {

    fun getName() : String {
        return fs.name
    }

    fun getMount() : String {
        return fs.mount
    }

    fun getFreeStorage() : StorageUnit {
        return StorageUnit(fs.freeSpace.toDouble())
    }

    fun getUsedStorage() : StorageUnit {
        return StorageUnit(fs.usableSpace.toDouble())
    }

    fun getTotalStorage() : StorageUnit {
        return StorageUnit(fs.totalSpace.toDouble())
    }

    fun getFreePercent() : Double {
        return Utils.calculatePercentage(fs.freeSpace.toDouble(), fs.totalSpace.toDouble())
    }

    fun getUsedPercent() : Double {
        return Utils.calculatePercentage(fs.usableSpace.toDouble(), fs.totalSpace.toDouble())
    }

    fun getFileStore() : OSFileStore {
        return fs
    }

    fun getDescription() : String {
        return fs.description
    }

    fun getLabel() : String {
        return fs.label
    }

}