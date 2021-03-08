package de.jan.systemutils

import oshi.SystemInfo
import oshi.hardware.CentralProcessor
import oshi.util.Util


class CPU(private val si: SystemInfo) {

    private var prevTicks = LongArray(CentralProcessor.TickType.values().size)

    fun getCPUUsage(): Double {
        val cpuLoad: Double = getProcessor().getSystemCpuLoadBetweenTicks(prevTicks) * 100
        prevTicks = getProcessor().systemCpuLoadTicks
        Util.sleep(2000)
        return cpuLoad
    }

    fun getProcessor() : CentralProcessor {
        return si.hardware.processor
    }


}