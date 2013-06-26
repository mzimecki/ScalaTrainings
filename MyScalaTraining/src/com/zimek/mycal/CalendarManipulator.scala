package com.zimek.mycal

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.Locale

import scala.collection.mutable.LinkedHashMap

/**
 * Provides useful methods connected to dates.
 */
object CalendarManipulator {
	val cal = new GregorianCalendar()
	val sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.US)
	val weekDays = LinkedHashMap[Int, Int]((1 -> Calendar.MONDAY), 
			(2 -> Calendar.TUESDAY), (3 -> Calendar.WEDNESDAY), (4 -> Calendar.THURSDAY),
			(5 -> Calendar.FRIDAY), (6 -> Calendar.SATURDAY), (7 -> Calendar.SUNDAY))
	
	/**
	 * Prints basic data of current date.
	 */
	def printBasicData() { 
		println("Today is: " + sdf.format(cal.getTime()) + ", week: " + cal.getMaximum(Calendar.WEEK_OF_YEAR)) 
	} 
	
	/**
	 * Prints months day numbers.
	 */
	def printMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1)
		weekDays.foreach(printDayAsString)
		val startingDayIdx = getDayIndex(cal.get(Calendar.DAY_OF_WEEK), weekDays.keysIterator)
		for(i <- 1 until startingDayIdx) print("    ")
		for (i <- 1 to cal.getActualMaximum(Calendar.DAY_OF_MONTH)) {
			if (i < 10)
				print(" " + i + "  ")
			else
				print(i + "  ")
			if ((i + startingDayIdx - 1) % 7 == 0) print("\n")
		}
	}
	
	/**
	 * Returns index (map key) of given day.
	 * 
	 * @param dayOfAweek Day constant from {@link: Calendar} class
	 * @param keysIterator Map keys iterator
	 */
	private def getDayIndex(dayOfAweek: Int, keysIterator: Iterator[Int]) : Int = {
		if(keysIterator.hasNext) {
			val key = keysIterator.next
			if(weekDays.getOrElse(key, -1) == dayOfAweek) key
			else getDayIndex(dayOfAweek, keysIterator)
		} else -1
	}
	
	/**
	 * Prints day name.
	 * 
	 * @param data data Tuple of index and day constant
	 */
	private def printDayAsString(data: (Int, Int)) {
		data match {
			case (1, Calendar.MONDAY) => print("Mon ")
			case (2, Calendar.TUESDAY) => print("Tue ")
			case (3, Calendar.WEDNESDAY) => print("Wed ")
			case (4, Calendar.THURSDAY) => print("Thu ")
			case (5, Calendar.FRIDAY) => print("Fri ")
			case (6, Calendar.SATURDAY) => print("Sat ")
			case (7, Calendar.SUNDAY) => print("Sun\n")
		}
	}
}