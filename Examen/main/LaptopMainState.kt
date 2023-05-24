package com.mateodevs.crudroom.main

data class LaptopMainState(
    val name: String="",
    val description: String="",
    val storage: Int=0,
    val processor: String="",
    val names: List<Laptop> = emptyList()
)
