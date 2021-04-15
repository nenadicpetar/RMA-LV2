package com.example.inspiringperson

class PeopleRepository private constructor() {

    private val persons: MutableList<InspiringPerson> = mutableListOf()

    private object HOLDER {
        val INSTANCE = PeopleRepository()
    }

    companion object {
        val instance: PeopleRepository by lazy { HOLDER.INSTANCE }
    }

    fun add(person: InspiringPerson)
    {
        persons.add(person)
    }

    fun length(): Int
    {
        return persons.size
    }

    fun getPerson(): MutableList<InspiringPerson>
    {
        return persons
    }
}