package edu.uc.hickmadc.customnotifications.dto

data class Alarm(
    var name: String,
    var desc: String,
    var active: Boolean,
    var random: Boolean,
    var alarmId: Int = 0
) {
    override fun toString(): String {
        return name
    }
}