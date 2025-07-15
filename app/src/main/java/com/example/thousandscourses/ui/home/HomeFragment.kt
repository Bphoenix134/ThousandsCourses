package com.example.thousandscourses.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thousandscourses.databinding.FragmentHomeBinding
import com.example.thousandscourses.ui.courseAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    private val adapter = ListDelegationAdapter(
        courseAdapterDelegate { course ->
            viewModel.toggleFavorite(course)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        Log.d("HomeFragment", "Fragment created")
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HomeFragment", "View created")
        binding.coursesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.coursesRecyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            Log.d("HomeFragment", "Starting to collect courses from ViewModel")
            viewModel.courses.collectLatest { courses ->
                Log.d("HomeFragment", "Received ${courses.size} courses from ViewModel")
                adapter.items = courses
                adapter.notifyDataSetChanged()
            }
        }

        binding.sortButton.setOnClickListener {
            viewModel.sortByPublishDate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("HomeFragment", "Fragment destroyed")
    }
}