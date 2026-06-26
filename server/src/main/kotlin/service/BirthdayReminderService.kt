package net.violetshine.app.service

import kotlin.time.Clock
import kotlinx.datetime.Month
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn

object BirthdayReminderService {
  // 1 July
  private const val DAY = 1
  private val month = Month.JULY
  
  fun shouldDisplayBirthday(): Boolean {
    val today = Clock.System.todayIn(TimeZone.UTC)

    return today.day == DAY && today.month == month
  }
}
