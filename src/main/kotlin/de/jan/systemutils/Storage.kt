package de.jan.systemutils

import oshi.SystemInfo
import oshi.software.os.FileSystem


class Storage(private val si: SystemInfo) {

    fun getDiskDriveWithMount(mount: String) : DiskDrive {
        for (fileStore in si.operatingSystem.fileSystem.fileStores) {
            if(fileStore.mount == mount) {
                return DiskDrive(fileStore)
            }
        }
        throw SystemUtilsException("No disk drive found with this mount")
    }

    fun getDiskDrives() : List<DiskDrive> {
        val list = ArrayList<DiskDrive>()
        for (fileStore in getFileSystem().fileStores) {
            list.add(DiskDrive(fileStore))
        }
        return list.toList()
    }

    fun getFileSystem() : FileSystem {
        return si.operatingSystem.fileSystem
    }

}