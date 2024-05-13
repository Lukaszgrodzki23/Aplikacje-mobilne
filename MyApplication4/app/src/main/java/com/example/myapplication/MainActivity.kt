package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyListFragment.Listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val container = findViewById<View>(R.id.fragment_container)
        if (container != null) {
            val infoFragment = InfoFragment()
            val sfm = supportFragmentManager.beginTransaction()
            sfm.replace(R.id.fragment_container, infoFragment)
            sfm.commit()
        }

    }

    override fun trailChosen(i: Int){
        val container = findViewById<View>(R.id.fragment_container)
        if (container != null){
            val infoFragment = InfoFragment()
            val bundle = Bundle()
            bundle.putString("index", i.toString())
            infoFragment.arguments = bundle
            val sfm = supportFragmentManager.beginTransaction()
            sfm.replace(R.id.fragment_container, infoFragment)
            sfm.commit()
        }
        else{
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("index", i.toString())
            startActivity(intent)
        }
    }
}