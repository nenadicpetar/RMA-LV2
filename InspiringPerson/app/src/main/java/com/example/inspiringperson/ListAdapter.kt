package com.example.inspiringperson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.person_list.view.*

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_list, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PersonViewHolder -> {
                holder.bind(PeopleRepository.instance.getPerson().get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return PeopleRepository.instance.length()
    }

    class PersonViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val personPhoto: ImageView = itemView.personPhoto
        private val personName: TextView = itemView.personName
        private val personDate: TextView = itemView.personDate
        private val personDescription: TextView = itemView.personDescription

        fun bind(person: InspiringPerson) {
            personName.text = person.name
            personDate.text = person.lifeDate()
            personDescription.text = person.description

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(person.photoURL)
                .into(personPhoto)

            personPhoto.setOnClickListener {
                Toast.makeText(itemView.context, person.quote, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}