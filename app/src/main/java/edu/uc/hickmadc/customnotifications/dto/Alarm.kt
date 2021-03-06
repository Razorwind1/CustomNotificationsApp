package edu.uc.hickmadc.customnotifications.dto

data class Alarm(
    var alarmName: String,
    var alarmDescription: String,
    var alarmActive: Boolean,
    var random: Boolean,
    var alarmId: Int = 0
) {
    override fun toString(): String {
        return alarmName
    }
}