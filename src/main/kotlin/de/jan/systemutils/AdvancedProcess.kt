package de.jan.systemutils

import oshi.SystemInfo
import oshi.software.os.OSProcess

class AdvancedProcess(private val si: SystemInfo, private val process: OSProcess) {

    private var previousTime: Long = 0

    fun getCPUUsage() : Double {
        val systemInfo = SystemInfo()
        val process = systemInfo.operatingSystem.getProcess(94880)
        val currentTime = process.kernelTime + process.userTime
        val timeDifference: Long = currentTime - previousTime

        val processCpu = 100 * (timeDifference / 5000.0)
        previousTime = currentTime
        System.out.format(
            "K: %d, U: %d, diff: %d, CPU: %.1f%n", process.kernelTime,
            process.userTime, timeDifference, processCpu
        )
        return processCpu
    }

}