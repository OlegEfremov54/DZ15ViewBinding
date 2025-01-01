package com.example.dz15viewbinding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dz15viewbinding.databinding.FragmentRecyclerViewBinding


class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycleView.adapter = CardsRecyclerViewAdapter(parentFragmentManager, Item.items)
    }

    override fun onResume() {
        super.onResume()
        Log.d("AAA", "onResume: recycler view fragment ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AAA", "onCreate: recycler view fragment")
    }

}