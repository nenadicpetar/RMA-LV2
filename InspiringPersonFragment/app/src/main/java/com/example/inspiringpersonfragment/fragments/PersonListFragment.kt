package com.example.inspiringpersonfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringpersonfragment.ItemClickType
import com.example.inspiringpersonfragment.PersonListAdapter
import com.example.inspiringpersonfragment.R
import com.example.inspiringpersonfragment.models.InspiringPerson
import com.example.inspiringpersonfragment.models.PeopleRepository
import kotlinx.android.synthetic.main.person_list_fragment.*

class PersonListFragment : Fragment(), PersonListAdapter.ContentListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.person_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setDefaultPerson()

        personList.layoutManager = LinearLayoutManager(view.context)
        personList.adapter = PersonListAdapter(this)

        newPeopleButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.container, PersonInputFragment())?.commit()
        }

    }

    override fun onItemClick(id: Int, clickType: ItemClickType) {
        if (clickType == ItemClickType.EDIT) {
            val bundle = Bundle()
            bundle.putInt("personId", id)

            val editFragment = PersonEditFragment()
            editFragment.arguments = bundle

            fragmentManager?.beginTransaction()?.replace(R.id.container, editFragment)?.commit()
        }
        else if (clickType == ItemClickType.REMOVE) {
            PeopleRepository.instance.getPersons().removeAt(id)

            personList.adapter?.notifyItemRemoved(id)
            personList.adapter?.notifyItemRangeChanged(id, PeopleRepository.instance.getPersons().size)
        }
    }

    private fun setDefaultPerson() {
        if (PeopleRepository.instance.length() != 0) {
            return
        }

        PeopleRepository.instance.add(
            InspiringPerson(
                "https://en.cryptonomist.ch/wp-content/uploads/2021/04/mvccopelonmusk.jpg",
                "Elon Musk",
                "28.06.1971.",
                "?",
                "Elon Musk je osnivač, glavni izvršni direktor i glavni tehnološki suradnik SpaceX-a, arhitekt proizvoda Tesla Inc.",
                "Upornost je jako važna. Ne bi trebali odustati osim ako niste prisiljeni na to."
            )
        )

        PeopleRepository.instance.add(
            InspiringPerson(
                "https://www.worldsultimate.net/wp-content/uploads/2017/08/Legend-Dennis-Ritchie.jpg",
                "Dennis Ritchie",
                "09.09.1941.",
                "12.10.2011.",
                "Denis Ritchie je bio američki računalni znanstvenik, tvorac programskog jezika C i ključna osoba u razvoju operacijskog sustava UNIX.",
                "UNIX je zapravo jednostavan operacijski sustav, ali trebate biti genij da razumijete jednostavnost."
            )
        )

        PeopleRepository.instance.add(
            InspiringPerson(
                "https://raw.githubusercontent.com/deepaksood619/TributeLinusTorvalds/master/torvald.jpg",
                "Linus Torvalds",
                "28.12.1969.",
                "?",
                "Finski znanstvenik, kreator Linux kernela. Također, kreirao je Git, sustav za verzioniranje koda.",
                "Računalo je kao klima uređaj, postaje beskorisno ako otvorite prozor (Windows)."
            )
        )

        PeopleRepository.instance.add(
            InspiringPerson(
                "https://www.heidelberg-laureate-forum.org/fileadmin/laureaten/Liskov_2.jpg",
                "Barbara Liskov",
                "07.11.1939.",
                "?",
                "Barbara Liskov je američka računalna znanstvenica, profesorica na Massachusetts Institute od Technology (MIT).",
                "Kada sve ostalo zakaže, ljudi se okreću razumu."
            )
        )

        PeopleRepository.instance.add(
            InspiringPerson(
                "https://static.dw.com/image/17321990_303.jpg",
                "Alan Turing",
                "23.06.1912.",
                "07.06.1950.",
                "Alan Mathison Turing je bio britanski matematičar, logičar i kriptoanalaitičar. Često se smatra ocem modernog računarstva.",
                "Računalo će zaslužiti da ga zovu inteligentnim ako zavara čovjeka da je i ono čovjek."
            )
        )
    }
}