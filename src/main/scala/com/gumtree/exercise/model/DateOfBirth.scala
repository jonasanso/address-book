package com.gumtree.exercise.model

import java.time.LocalDate
import java.time.format.{DateTimeFormatter, DateTimeFormatterBuilder}
import java.time.temporal.ChronoField

case class DateOfBirth(value: LocalDate) extends AnyVal {
  def daysOlder(than: DateOfBirth): Long = java.time.temporal.ChronoUnit.DAYS.between(value, than.value)
}

object DateOfBirth {
  val formatter: DateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/")
    .appendValueReduced(
      ChronoField.YEAR, 2, 2, 1920
    ).toFormatter()

  def orderAsc: Ordering[DateOfBirth] = Ordering.fromLessThan(_.value isBefore _.value)

  def apply(value: String): DateOfBirth = new DateOfBirth(parseDate(value.trim))

  private def parseDate(date: String): LocalDate = {
    LocalDate.parse(date, formatter)
  }
}

