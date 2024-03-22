package com.example.mountain_trails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MountainTrailAdapter(private val trails: List<Trail>, private val onClick: (Trail) -> Unit) :
    RecyclerView.Adapter<MountainTrailAdapter.TrailViewHolder>() {

    class TrailViewHolder(view: View, val onClick: (Trail) -> Unit) : RecyclerView.ViewHolder(view) {
        private val trailNameTextView: TextView = view.findViewById(R.id.trailNameTextView)
        private var currentTrail: Trail? = null

        init {
            view.setOnClickListener {
                currentTrail?.let {
                    onClick(it)
                }
            }
        }

        fun bind(trail: Trail) {
            currentTrail = trail
            trailNameTextView.text = trail.getName()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.trail, parent, false)
        return TrailViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: TrailViewHolder, position: Int) {
        val trail = trails[position]
        holder.bind(trail)
    }

    override fun getItemCount() = trails.size
}
