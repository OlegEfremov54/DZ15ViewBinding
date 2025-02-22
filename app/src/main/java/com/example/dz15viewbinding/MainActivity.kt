package com.example.dz15viewbinding

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dz15viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, RecyclerViewFragment(), "RecyclerView")
            .commit()

        //Тулбар
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Дизайн Dashboard"
        toolbarMain.subtitle = " Версия 1. Главная страница"
        toolbarMain.setLogo(R.drawable.diplomamini)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbarMain.setNavigationOnClickListener { onBackPressed() }

    }
    //Обработка кнопки Возврат в Тулбаре
    override fun onBackPressed() {
        val backStackCount = supportFragmentManager.backStackEntryCount
        if (backStackCount > 0) {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
            if (currentFragment is ClickableCard) {
                currentFragment.onBackPressed()
            }
        }
        else super.onBackPressed()
    }

    //Инициализация Меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.infoMenuMain -> {
                Toast.makeText(
                    applicationContext, "Автор Ефремов О.В. Создан 31.12.2024",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                Toast.makeText(
                    applicationContext, "Работа приложения завершена",
                    Toast.LENGTH_LONG
                ).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}