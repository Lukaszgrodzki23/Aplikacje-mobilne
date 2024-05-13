package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.R.*
class InfoActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val index = intent?.extras?.getString("index")
        val bundle = Bundle()
        bundle.putString("index", index)
        (supportFragmentManager.findFragmentById(id.info_fragment) as? InfoFragment)?.setArguments(
            bundle
        )
    }
}