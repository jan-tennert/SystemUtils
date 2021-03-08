package de.jan.systemutils

import java.lang.management.OperatingSystemMXBean
import java.util.*
import java.util.Optional

import javax.management.ObjectName

import java.lang.management.ManagementFactory
import java.util.function.Function
import javax.management.Attribute
import javax.management.AttributeList

import javax.management.MBeanServer




class RaspberryPi {

    fun getModel() : String {
        return "cat /sys/firmware/devicetree/base/model".execute()
    }

    fun getGPUTemperature() : Double {
        val string = "vcgencmd measure_temp".execute().replace("'C", "").replace("temp=", "")
        return string.toDouble()
    }

    fun getCPUTemperature(): Double {
        val string = "cat /sys/class/thermal/thermal_zone0/temp".execute().replace("\n", "").replace(" ", "")
        return string.toInt() / 1000.toDouble()
    }

    /*
    Only works on my raspberrypi!
     */
    fun getFan() : RaspberryPiFan {
        return RaspberryPiFan()
    }

}

fun String.execute() : String {
    val s = Scanner(Runtime.getRuntime().exec(this).inputStream).useDelimiter("\\A")
    return if (s.hasNext()) s.next() else ""
}