package com.mateodevs.crudroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class LaptopEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val description: String,
    val storage: Int,
    val processor: String,
)
