package com.example.myapplication

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

class MountainTrailAdapter(private val trails: Serializable?, private val onClick: (Trail) -> Unit) :
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

    override fun getItemCount(): Int {
        val list =(trails as? ArrayList<Trail>)
        if (list != null) {
            return list.size
        }
        return 0
    }
}

private operator fun Serializable?.get(position: Int): Trail {
    val list = this as? List<Trail> ?: throw IllegalArgumentException("Serializable object is not a List of Trail.")

    if (position !in list.indices) {
        throw IndexOutOfBoundsException("Position $position is out of bounds for the list of size ${list.size}.")
    }

    return list[position]
}

