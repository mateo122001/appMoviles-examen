package com.mateodevs.crudroom.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LaptopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertLaptop(laptop:LaptopEntity)

    @Query("SELECT * FROM LaptopEntity")
    suspend fun getLaptops():List<LaptopEntity>

}

