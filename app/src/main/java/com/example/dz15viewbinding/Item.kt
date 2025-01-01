package com.example.dz15viewbinding

class Item(val title: String, val iconResource: Int, val fragment: ClickableCard) {
    companion object {
        val items = listOf(
            Item("Профиль", R.drawable.baseline_co_present_24, ProfileFragment()),
            Item("Задачи", R.drawable.baseline_chat_24, TasksFragment()),
            Item("Почта", R.drawable.baseline_email_24, MailFragment()),
            Item("Проект", R.drawable.baseline_data_exploration_24, ProjectFragment()),
        )
    }
}