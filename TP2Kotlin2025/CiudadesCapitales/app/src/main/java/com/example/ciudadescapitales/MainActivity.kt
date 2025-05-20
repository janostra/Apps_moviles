package com.example.ciudadescapitales

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToAdd = findViewById<Button>(R.id.buttonGoToAdd)
        val buttonGoToSearch = findViewById<Button>(R.id.buttonGoToSearch)
        val buttonGoToDeleteByCountry = findViewById<Button>(R.id.buttonGoToDeleteByCountry)

        buttonGoToAdd.setOnClickListener {
            startActivity(Intent(this, AddCityActivity::class.java))
        }

        buttonGoToSearch.setOnClickListener {
            startActivity(Intent(this, SearchCityActivity::class.java))
        }

        buttonGoToDeleteByCountry.setOnClickListener {
            startActivity(Intent(this, DeleteByCountryActivity::class.java))
        }
    }
}
