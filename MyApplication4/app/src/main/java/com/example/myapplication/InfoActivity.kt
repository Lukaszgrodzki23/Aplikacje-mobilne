package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val bundle = Bundle()
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_info)
        val info = intent.getStringExtra("info") ?: "No information"
        val name = intent.getStringExtra("name") ?: "No name"
        val fragment = InfoFragment()
        bundle.putString("info", info)
        bundle.putString("name", name)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}


