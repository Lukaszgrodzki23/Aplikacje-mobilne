package com.example.mountain_trails

import android.os.Bundle
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
import com.example.mountain_trails.ui.theme.Mountain_trailsTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mountainTrailsRecyclerView: RecyclerView = findViewById(R.id.recycler)
        mountainTrailsRecyclerView.layoutManager = LinearLayoutManager(this)

        // Sample list of trails
        val trails = listOf(
            Trail("Trail A"),
            Trail("Trail B"),
            Trail("Trail C")
        )

        // Set up the RecyclerView with the adapter
        mountainTrailsRecyclerView.adapter = MountainTrailAdapter(trails) { trail ->
            // Handle the trail click here. For example:
            Toast.makeText(this, "Clicked on ${trail.getName()}", Toast.LENGTH_SHORT).show()
        }
    }
}
