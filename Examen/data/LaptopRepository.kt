package com.mateodevs.crudroom.data

import com.mateodevs.crudroom.main.Laptop

class LaptopRepository(private val laptopDao:LaptopDao) {

    suspend fun getLaptops(): List<Laptop> {
        val entities = laptopDao.getLaptops()
        return entities.map {
            Laptop(name = it.name, description = it.description, storage = it.storage, processor = it.processor)
        }
    }

    suspend fun insertLaptop(laptop: Laptop) {
        val entity = LaptopEntity(name = laptop.name, description = laptop.description, storage = laptop.storage, processor = laptop.processor)
        laptopDao.insertLaptop(entity)
    }
}
