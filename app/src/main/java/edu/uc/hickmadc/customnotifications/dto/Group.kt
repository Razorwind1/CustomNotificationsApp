package edu.uc.hickmadc.customnotifications.dto

data class Group(
    var groupName: String,
    var groupDescription: String,
    var groupActive: Boolean,
    var sameSchedule: Boolean,
    var groupId: Int = 0
) {
    override fun toString(): String {
        return groupName
    }
}