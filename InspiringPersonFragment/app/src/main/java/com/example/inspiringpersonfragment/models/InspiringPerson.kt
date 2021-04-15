package com.example.inspiringpersonfragment.models

class InspiringPerson (
    val photoURL: String,
    val name: String,
    val birthDate: String,
    val deathDate: String,
    val description: String,
    val quote: String
    ) {

    fun lifeDates(): String {
        return "$birthDate - $deathDate"
    }
}
