package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R.*

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layout.fragment_info, container, false)
        val nameView = view.findViewById<TextView>(R.id.nameView)
        val infoView = view.findViewById<TextView>(R.id.infoView)
        infoView.text = arguments?.getString("info") ?: "123"
        nameView.text = arguments?.getString("name") ?: "123"

        return view
    }
}