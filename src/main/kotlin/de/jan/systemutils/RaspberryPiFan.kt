package de.jan.systemutils

class RaspberryPiFan {

    private val fanPath = "/home/pi/Fan/fan_control.py"

    fun enableFan() {
        Runtime.getRuntime().exec("$fanPath --on")
    }

    fun disableFan() {
        Runtime.getRuntime().exec("$fanPath --off")
    }


}