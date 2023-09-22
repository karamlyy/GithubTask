package com.example.githubtask.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubtask.R
import com.example.githubtask.adapter.RecyclerViewAdapter
import com.example.githubtask.viewmodel.DateFilter
import com.example.githubtask.viewmodel.SharedViewModel


class WeekFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        viewModel.handleError = showError
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_week, container, false)
        adapter = RecyclerViewAdapter(emptyList())
        viewModel.getRepository(DateFilter.WEEK)
        viewModel.week.observeForever{
            adapter.setData(it)
        }
        val recyclerView: RecyclerView = view.findViewById(R.id.lastWeekTrendingRepoRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        return view
    }

    private val showError: (Throwable) -> Unit = {
    }
}