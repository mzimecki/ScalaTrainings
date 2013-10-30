package com.zimek.mycal

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale

/**
 * Provides useful methods connected to dates.
 */
object CalendarManipulator {
  private val cal = new GregorianCalendar
  private val sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.US)
  private val weekDays = List[(Int, Int)]((1 -> Calendar.MONDAY),
    (2 -> Calendar.TUESDAY), (3 -> Calendar.WEDNESDAY), (4 -> Calendar.THURSDAY),
    (5 -> Calendar.FRIDAY), (6 -> Calendar.SATURDAY), (7 -> Calendar.SUNDAY))

  /**
   * Prints months day numbers.
   */
  def printMonth() { print(getBasicData + daysAsString.mkString + getEmptyDaysGap + monthTable.mkString) }

  /**
   * Returns string with all week days as text.
   */
  private def daysAsString: String = {
      def iterate(days: List[(Int, Int)], acc: String): String = {
        if (days.isEmpty) acc
        else iterate(days.tail, acc + getDayAsString(days.head._2))
      }
    iterate(weekDays, "")
  }
  
  val lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
  
  /**
   * Returns moth table as string.
   */
  private def monthTable(): String = {
    (for {
      i <- 1 to lastDayOfMonth
      if (i < lastDayOfMonth)
    } yield makeDaySequence(i)).mkString
  }

  /**
   * Prints basic data of current date.
   */
  private def getBasicData = "Today is: " + sdf.format(cal.getTime()) + ", week: " + cal.getMaximum(Calendar.WEEK_OF_YEAR) + "\n\n"

  /**
   * Returns string representing one day entry in calendar.
   */
  private def makeDaySequence(dayNo: Int) = {
    val padding = " " * (4 - dayNo.toString.length())
    if ((dayNo + getIndexOfFirstDayOfaMonth - 1) % 7 == 0)
      padding + dayNo + "\n"
    else
      padding + dayNo
  }

  /**
   * Returns space until first day of a month.
   */
  private def getEmptyDaysGap = "    " * (getIndexOfFirstDayOfaMonth - 1)

  /**
   * Returns starting column of the first day of a month.
   */
  private def getIndexOfFirstDayOfaMonth = {
    cal.set(Calendar.DAY_OF_MONTH, 1)
    getDayIndex(cal.get(Calendar.DAY_OF_WEEK))
  }

  /**
   * Returns index (map key) of given day.
   *
   * @param dayOfAweek Day constant from {@link: Calendar} class
   */
  private def getDayIndex(dayOfAweek: Int): Int = {
      def findIdx(days: List[(Int, Int)]): Int = {
        if (days.isEmpty) -1
        else if (days.head._2 == dayOfAweek) days.head._1
        else findIdx(days.tail)
      }
    findIdx(weekDays)
  }

  /**
   * Prints day name.
   *
   * @param data data Tuple of index and day constant
   */
  private def getDayAsString(data: Int) = data match {
    case Calendar.MONDAY => " Mon "
    case Calendar.TUESDAY => "Tue "
    case Calendar.WEDNESDAY => "Wed "
    case Calendar.THURSDAY => "Thu "
    case Calendar.FRIDAY => "Fri "
    case Calendar.SATURDAY => "Sat "
    case Calendar.SUNDAY => "Sun\n"
  }
}