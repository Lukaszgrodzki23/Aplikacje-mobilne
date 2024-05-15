package com.example.myapplication

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), MyListFragment.Listener {
    private val ACTIVITY_RECOGNITION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check for activity recognition permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                    ACTIVITY_RECOGNITION_REQUEST_CODE)
            } else {
                // Permission already granted
                initializeFragment()
            }
        } else {
            // Permission not required for versions below Q
            initializeFragment()
        }
    }

    private fun initializeFragment() {
        val container = findViewById<View>(R.id.fragment_container)
        if (container != null) {
            val infoFragment = InfoFragment()
            val sfm = supportFragmentManager.beginTransaction()
            sfm.replace(R.id.fragment_container, infoFragment)
            sfm.commit()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == ACTIVITY_RECOGNITION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permission granted
                initializeFragment()
            } else {
                // Permission denied
                Toast.makeText(this, "Activity recognition permission is required to use the step counter.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun trailChosen(i: Int) {
        val container = findViewById<View>(R.id.fragment_container)
        if (container != null) {
            val infoFragment = InfoFragment()
            val bundle = Bundle()
            bundle.putString("index", i.toString())
            infoFragment.arguments = bundle
            val sfm = supportFragmentManager.beginTransaction()
            sfm.replace(R.id.fragment_container, infoFragment)
            sfm.commit()
        } else {
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("index", i.toString())
            startActivity(intent)
        }
    }
}
