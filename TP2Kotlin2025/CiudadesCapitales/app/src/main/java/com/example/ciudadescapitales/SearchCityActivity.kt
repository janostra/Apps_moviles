package com.example.ciudadescapitales

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SearchCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_city)

        val etCityName = findViewById<EditText>(R.id.editTextSearchCity)
        val btnSearch = findViewById<Button>(R.id.buttonSearch)
        val btnDelete = findViewById<Button>(R.id.buttonDelete)
        val btnUpdate = findViewById<Button>(R.id.buttonUpdate)
        val etPopulationUpdate = findViewById<EditText>(R.id.editTextNewPopulation)
        val tvResult = findViewById<TextView>(R.id.textViewResult)

        btnSearch.setOnClickListener {
            val cityName = etCityName.text.toString().trim()
            if (cityName.isEmpty()) {
                Toast.makeText(this, "Ingrese nombre de ciudad", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val city = CityRepository.findCityByName(cityName)
            if (city != null) {
                tvResult.text = "País: ${city.country}\nCiudad: ${city.city}\nPoblación: ${city.population}"
            } else {
                tvResult.text = "Ciudad no encontrada"
            }
        }

        btnDelete.setOnClickListener {
            val cityName = etCityName.text.toString().trim()
            if (cityName.isEmpty()) {
                Toast.makeText(this, "Ingrese nombre de ciudad", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val deleted = CityRepository.deleteCityByName(cityName)
            if (deleted) {
                Toast.makeText(this, "Ciudad eliminada", Toast.LENGTH_SHORT).show()
                tvResult.text = ""
            } else {
                Toast.makeText(this, "Ciudad no encontrada", Toast.LENGTH_SHORT).show()
            }
        }

        btnUpdate.setOnClickListener {
            val cityName = etCityName.text.toString().trim()
            val newPopulationStr = etPopulationUpdate.text.toString().trim()
            if (cityName.isEmpty() || newPopulationStr.isEmpty()) {
                Toast.makeText(this, "Ingrese ciudad y nueva población", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val newPopulation = newPopulationStr.toIntOrNull()
            if (newPopulation == null || newPopulation <= 0) {
                Toast.makeText(this, "Población inválida", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val updated = CityRepository.updatePopulation(cityName, newPopulation)
            if (updated) {
                Toast.makeText(this, "Población actualizada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ciudad no encontrada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
