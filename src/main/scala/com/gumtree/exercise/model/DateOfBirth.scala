package com.gumtree.exercise.model

class DateOfBirth(val value: String) extends AnyVal
object DateOfBirth {
  def apply(value: String): DateOfBirth = new DateOfBirth(value.trim)
}

