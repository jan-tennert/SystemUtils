package de.jan.systemutils

class RaspberryPiFan {

    private val fanPath = "/home/pi/Fan/fan_control.py"

    fun enableFan() {
        "$fanPath --on".execute()
    }

    fun disableFan() {
        "$fanPath --on".execute()
    }


}