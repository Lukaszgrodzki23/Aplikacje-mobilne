package com.example.myapplication

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R.*


class MyListFragment : ListFragment() {

    interface Listener {
        fun trailChosen(i: Int)
    }

    private var listener: Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val names = Array(Trail.trails.size) { i -> Trail.trails[i].getName() }
        val adapter = ArrayAdapter(inflater.context, R.layout.simple_list_item_1, names)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Listener) {
            this.listener = context
        }
    }

    override fun onListItemClick(list: ListView, item: View, position: Int, index: Long) {
        listener?.trailChosen(index.toInt())
    }
}