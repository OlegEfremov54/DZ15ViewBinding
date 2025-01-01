package com.example.dz15viewbinding

import androidx.fragment.app.FragmentManager

interface ClickableCard {
    fun onClick(fragmentManager: FragmentManager)
    fun onBackPressed()
}