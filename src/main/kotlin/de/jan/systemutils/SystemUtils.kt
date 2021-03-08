package de.jan.systemutils

import oshi.SystemInfo
import oshi.hardware.ComputerSystem
import oshi.hardware.GraphicsCard
import oshi.hardware.HardwareAbstractionLayer
import oshi.hardware.NetworkIF
import oshi.software.os.OperatingSystem


object Utils {

    fun calculatePercentage(obtained: Double, total: Double): Double {
        return obtained * 100 / total
    }

}

class SystemUtilsException(message: String) : Exception(message)

fun Double.round(decimal_places: Int) : Double {
    return String.format("%.${decimal_places}f", this).replace(",", ".").toDouble()
}

fun Float.round(decimal_places: Int) : Float {
    return String.format("%.${decimal_places}f", this).replace(",", ".").toFloat()
}

class SystemUtils {

    private val si = SystemInfo()

    fun getMemory() : Memory {
        return Memory(si)
    }

    fun getCPU() : CPU {
        return CPU(si)
    }

    fun getStorage() : Storage {
        return Storage(si)
    }

    fun getOperatingSystem() : OperatingSystem {
        return si.operatingSystem
    }

    fun getHardware() : HardwareAbstractionLayer {
        return si.hardware
    }

    fun getComputerSystem() : ComputerSystem {
        return si.hardware.computerSystem
    }

    fun getGraphicCards() : List<GraphicsCard> {
        return si.hardware.graphicsCards
    }

    fun getNetworkAdapters() : List<NetworkIF> {
        return si.hardware.networkIFs
    }

    fun getOSName() : String {
        return si.operatingSystem.family
    }

}