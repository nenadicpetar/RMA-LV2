package com.example.inspiringperson

class InspiringPerson(
    val photoURL: String,
    val name: String,
    private val birthDate: String,
    private val deathDate: String,
    val description: String,
    val quote: String
    ) {

    fun lifeDate(): String {
        return "$birthDate - $deathDate";
    }
}