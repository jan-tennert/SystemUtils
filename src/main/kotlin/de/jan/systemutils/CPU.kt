package de.jan.systemutils

import com.sun.management.OperatingSystemMXBean
import oshi.SystemInfo
import oshi.hardware.CentralProcessor
import java.lang.management.ManagementFactory





class CPU(private val si: SystemInfo) {

    var prevTicks = LongArray(CentralProcessor.TickType.values().size)

    @Deprecated("Use oshi instead")
    fun getCPUUsage(): Double {
        val osBean: OperatingSystemMXBean = ManagementFactory.getPlatformMXBean(
            OperatingSystemMXBean::class.java)
        return osBean.systemCpuLoad + osBean.processCpuLoad
    }

    fun getProcessor() : CentralProcessor {
        return si.hardware.processor
    }

}
