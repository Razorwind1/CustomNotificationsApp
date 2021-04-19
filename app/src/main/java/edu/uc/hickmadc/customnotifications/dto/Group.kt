package edu.uc.hickmadc.customnotifications.dto

data class Group (var name : String, var desc : String, var active : Boolean, var same_schedule : Boolean, var groupId:Int=0) {
    override fun toString(): String {
        return "id: $groupId, name: $name, desc: $desc, active: $active, same_schedule: $same_schedule"
    }
}
