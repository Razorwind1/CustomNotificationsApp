package edu.uc.hickmadc.customnotifications

import edu.uc.hickmadc.customnotifications.dto.Alarm
import edu.uc.hickmadc.customnotifications.dto.Group
import edu.uc.hickmadc.customnotifications.dto.Schedule
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun confirmsAlam_outputsAlarm () {
        var alarmTest: Alarm = Alarm("School Test", "Test for class", true, false, 1)
        assertEquals("School Test", alarmTest.toString());
    }

    @Test
    fun confirmsGroup_outputsGroup () {
        var groupTest: Group = Group("Testing Group", "Test for class", true, false, 1)
        assertEquals("Testing Group", groupTest.toString());
    }

    @Test
    fun confirmsSchedule_outputsSchedule () {
        val cal = Calendar.getInstance()
        var scheduleTest: Schedule = Schedule(cal, 5, 1)
        assertEquals(cal, scheduleTest.originalOccurance);
    }
}