package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var firstButton: Button
    lateinit var secondButton: Button
    lateinit var thirdButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        firstButton = findViewById(R.id.firstButton)
        secondButton = findViewById(R.id.secondButton)
        thirdButton = findViewById(R.id.thirdButton)

        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()
        fragmentTransaction.add(R.id.firtstFrame, firstFragment)
        fragmentTransaction.commit()

        secondButton.setOnClickListener {
            val secondFragmentManager: FragmentManager = supportFragmentManager
            val transaction = secondFragmentManager.beginTransaction()
            val secondFragment: SecondFragment = SecondFragment()
            transaction.replace(R.id.firtstFrame, secondFragment)
            transaction.commit()
        }
        firstButton.setOnClickListener {
            val secondFragmentManager: FragmentManager = supportFragmentManager
            val transaction = secondFragmentManager.beginTransaction()
            transaction.replace(R.id.firtstFrame, firstFragment)
            transaction.commit()
        }
    }
}