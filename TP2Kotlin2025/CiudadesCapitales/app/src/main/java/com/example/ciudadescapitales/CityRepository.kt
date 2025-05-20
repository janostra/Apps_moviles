package com.example.ciudadescapitales

object CityRepository {
    val cities = mutableListOf<CapitalCity>()

    fun addCity(city: CapitalCity) {
        cities.add(city)
    }

    fun findCityByName(cityName: String): CapitalCity? {
        return cities.find { it.city.equals(cityName, ignoreCase = true) }
    }

    fun deleteCityByName(cityName: String): Boolean {
        return cities.removeIf { it.city.equals(cityName, ignoreCase = true) }
    }

    fun deleteCitiesByCountry(countryName: String): Boolean {
        return cities.removeIf { it.country.equals(countryName, ignoreCase = true) }
    }

    fun updatePopulation(cityName: String, newPopulation: Int): Boolean {
        val city = findCityByName(cityName)
        city?.let {
            it.population = newPopulation
            return true
        }
        return false
    }
}
