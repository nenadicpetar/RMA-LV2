package com.example.inspiringpersonfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inspiringpersonfragment.fragments.PersonListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, PersonListFragment()).commit()
    }
}