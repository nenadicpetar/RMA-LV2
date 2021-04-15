package com.example.inspiringperson

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.person_input.*

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_input)

        val actionbar = supportActionBar

        actionbar!!.title = "Unos novih osoba"

        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDefaultDisplayHomeAsUpEnabled(true)
        actionbar.setDefaultDisplayHomeAsUpEnabled(true)

        inputButton.setOnClickListener {
            val newPerson = InspiringPerson(
                photo.text.toString(),
                name.text.toString(),
                birthDate.text.toString(),
                deathDate.text.toString(),
                description.text.toString(),
                inputQuote.text.toString()
            )
            PeopleRepository.instance.add(newPerson)

            photo.text.clear()
            name.text.clear()
            birthDate.text.clear()
            deathDate.text.clear()
            description.text.clear()
            inputQuote.text.clear()

            Toast.makeText(this, "Spremili ste osobu.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}