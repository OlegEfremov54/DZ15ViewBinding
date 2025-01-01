package com.example.dz15viewbinding

data class Task(val id: Int = counter, val content: String, var check: Boolean = false) {
    companion object {
        var counter = 1
        val tasks = mutableListOf(
            Task(content = "Заметка №1"),
            Task(content = "Заметка №2. Тут столько текста"),
            Task(content = "Заметка №3. Тет текста еще больше"),
            Task(content = "Заметка №4. Вообще жесть как много текста", check = true),
            Task(content = "Заметка №5. Пока"),
        )
    }

    init {
        counter++
    }

}