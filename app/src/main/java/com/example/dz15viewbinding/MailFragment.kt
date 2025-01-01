package com.example.dz15viewbinding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.dz15viewbinding.databinding.FragmentMailBinding


class MailFragment : Fragment(R.layout.fragment_mail), ClickableCard {
    private var _binding: FragmentMailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mailRv.adapter = MailRecyclerViewAdapter(Mail.mailList)
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

    override fun onResume() {
        super.onResume()
        Log.d("AAA", "onResume: mail fragment ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AAA", "onCreate: mail fragment")
    }


}