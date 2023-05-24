package com.mateodevs.crudroom.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LaptopEntity::class], version = 1)
abstract class LaptopDatabase: RoomDatabase() {

abstract val dao:LaptopDao
}
