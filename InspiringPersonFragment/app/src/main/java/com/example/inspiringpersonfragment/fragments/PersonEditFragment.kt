package com.example.inspiringpersonfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.inspiringpersonfragment.R
import com.example.inspiringpersonfragment.models.InspiringPerson
import com.example.inspiringpersonfragment.models.PeopleRepository
import kotlinx.android.synthetic.main.person_input_fragment.*

class PersonEditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.person_input_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = arguments
        val personId = bundle?.getInt("personId")
        val inspiringPerson = PeopleRepository.instance.getPerson(personId)

        inputPhoto.setText(inspiringPerson?.photoURL)
        inputName.setText(inspiringPerson?.name)
        inputBirthDate.setText(inspiringPerson?.birthDate)
        inputDeathDate.setText(inspiringPerson?.deathDate)
        inputDescription.setText(inspiringPerson?.description)
        inputQuote.setText(inspiringPerson?.quote)

        inputButton.setOnClickListener {
            val tmpPerson = InspiringPerson(
                inputPhoto.text.toString(),
                inputName.text.toString(),
                inputBirthDate.text.toString(),
                inputDeathDate.text.toString(),
                inputDescription.text.toString(),
                inputQuote.text.toString()
            )

            if(personId != null) {
                PeopleRepository.instance.set(tmpPerson, personId)
                Toast.makeText(view.context, "Ta osoba je već u repozitoriju!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        peopleListActivity.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.container, PersonListFragment())?.commit()
        }
    }
}