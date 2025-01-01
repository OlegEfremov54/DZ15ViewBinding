package com.example.dz15viewbinding

data class Task(val id: Int = counter, val content: String, var check: Boolean = false) {
    companion object {
        var counter = 1
        val tasks = mutableListOf(
            Task(content = "Заметка №1. Приготовили программу"),
            Task(content = "Заметка №2. Оттестировали программу"),
            Task(content = "Заметка №3. Программа понравилась"),
            Task(content = "Заметка №4. Вообще супер приложение", check = true),
            Task(content = "Заметка №5. Мы счастливы"),
        )
    }

    init {
        counter++
    }

}