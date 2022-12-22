package com.example.appejemplocomunicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private val viewModelApp: ViewModelApp by viewModels()

    private val fragmentManager: FragmentManager by lazy { supportFragmentManager }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        goToSecondFragment()

        createNewActivity()

        goToFirstFragment()

    }

    private fun goToSecondFragment() {
        viewModelApp.navigation.observe(this){
            if (it){
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_conteiner, SegundoFragment())
                    .commit()
            }
        }
    }

    private fun init() {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_conteiner, FirstFragment())
            .commit()
    }

    private fun createNewActivity(){
        viewModelApp.createNewActivity.observe(this){
            if (it){
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }

    private fun goToFirstFragment() {
        viewModelApp.navigationToFirstFragment.observe(this){
            if (it){
                fragmentManager.beginTransaction()
                    .replace(R.id.fragment_conteiner, FirstFragment())
                    .commit()
            }
        }
    }
}