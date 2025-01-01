package com.example.dz15viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.dz15viewbinding.databinding.FragmentProjectBinding

class ProjectFragment : Fragment(R.layout.fragment_project), ClickableCard {

    private var _binding: FragmentProjectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.projectChartIv.setImageResource(R.drawable.gantdiagram)
        binding.projectTitleTv.text = getString(R.string.project_title)
        binding.projectDescriptionTv.text = getString(R.string.project_description)
    }


    override fun onClick(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, this)
            .commit()
    }

    override fun onBackPressed() {
        val mainFragment = parentFragmentManager.findFragmentByTag("RecyclerView")!!
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, mainFragment)
            .commit()
    }

}