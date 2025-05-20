package com.example.ciudadescapitales

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DeleteByCountryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_by_country)

        val etCountryName = findViewById<EditText>(R.id.editTextCountryToDelete)
        val btnDeleteCountry = findViewById<Button>(R.id.buttonDeleteByCountry)

        btnDeleteCountry.setOnClickListener {
            val countryName = etCountryName.text.toString().trim()
            if (countryName.isEmpty()) {
                Toast.makeText(this, "Ingrese nombre de país", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val deleted = CityRepository.deleteCitiesByCountry(countryName)
            if (deleted) {
                Toast.makeText(this, "Ciudades de $countryName eliminadas", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No se encontraron ciudades para ese país", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
