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
	 * Prints months day numbers.
	 */
	def printMonth() {
		val days = 
			for(weekDay <- weekDays)
				yield getDayAsString(weekDay._2)
		
		val monthTable = 
			for (i <- 1 to cal.getActualMaximum(Calendar.DAY_OF_MONTH)) 
				yield makeDaySequence(i)
		
		print(getBasicData + days.mkString + getEmptyDaysGap + monthTable.mkString)
	}
	
	/**
	 * Prints basic data of current date.
	 */
	def getBasicData = "Today is: " + sdf.format(cal.getTime()) + ", week: " + cal.getMaximum(Calendar.WEEK_OF_YEAR) + "\n\n"
	
	/**
	 * Returns string representing one day entry in calendar.
	 */
	def makeDaySequence(dayNo: Int) = { 
		val padding = " " * (4 - dayNo.toString.length())
		if((dayNo + getIndexOfFirstDayOfaMonth - 1) % 7 == 0) 
			padding + dayNo + "\n" 
		else 
			padding + dayNo 
	}
	
	/**
	 * Returns space until first day of a month.
	 */
	def getEmptyDaysGap = "    " * (getIndexOfFirstDayOfaMonth - 1) 
	
	/**
	 * Returns starting column of the first day of a month.
	 */
	def getIndexOfFirstDayOfaMonth = { 
		cal.set(Calendar.DAY_OF_MONTH, 1)
		getDayIndex(cal.get(Calendar.DAY_OF_WEEK), weekDays.keysIterator)
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
	private def getDayAsString(data: Int) = {
		data match {
			case Calendar.MONDAY => " Mon "
			case Calendar.TUESDAY => "Tue "
			case Calendar.WEDNESDAY => "Wed "
			case Calendar.THURSDAY => "Thu "
			case Calendar.FRIDAY => "Fri "
			case Calendar.SATURDAY => "Sat "
			case Calendar.SUNDAY => "Sun\n"
		}
	}
}