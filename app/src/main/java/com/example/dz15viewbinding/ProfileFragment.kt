package com.example.dz15viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.dz15viewbinding.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile), ClickableCard {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.profileNameTv.text = "Олег Ефремов"
    binding.profileAboutTv.text = "Чтение книг, колекционирование, програмирование"
    binding.profileImageIv.setImageResource(R.drawable.flaffi)

}

override fun onClick(fragmentManager: FragmentManager) {
    fragmentManager.beginTransaction()
        .replace(R.id.fragment_container, this)
        .addToBackStack("")
        .commit()
}

override fun onBackPressed() {
    val mainFragment = parentFragmentManager.findFragmentByTag("RecyclerView")!!
    parentFragmentManager.beginTransaction()
        .replace(R.id.fragment_container, mainFragment)
        .commit()
}
}