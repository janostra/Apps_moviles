package com.example.ciudadescapitales

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        val etCountry = findViewById<EditText>(R.id.editTextCountry)
        val etCity = findViewById<EditText>(R.id.editTextCity)
        val etPopulation = findViewById<EditText>(R.id.editTextPopulation)
        val btnAdd = findViewById<Button>(R.id.buttonAdd)

        btnAdd.setOnClickListener {
            val country = etCountry.text.toString().trim()
            val city = etCity.text.toString().trim()
            val populationStr = etPopulation.text.toString().trim()

            if (country.isEmpty() || city.isEmpty() || populationStr.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val population = populationStr.toIntOrNull()
            if (population == null || population <= 0) {
                Toast.makeText(this, "Población inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newCity = CapitalCity(country, city, population)
            CityRepository.addCity(newCity)
            Toast.makeText(this, "Ciudad agregada", Toast.LENGTH_SHORT).show()

            // Limpiar campos
            etCountry.text.clear()
            etCity.text.clear()
            etPopulation.text.clear()
        }
    }
}
