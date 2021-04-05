package edu.uc.hickmadc.customnotifications.dto

data class Group (var name : String, var desc : String, var active : Boolean, var same_schedule : Boolean, var group_id:Int=0) {
    override fun toString(): String {
        return name
    }
}