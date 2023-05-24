package com.mateodevs.crudroom.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LaptopScreen(viewModel: MainViewModel, navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Consulta de los registros de la BD") }
        )
    }) { padding ->
        val state = viewModel.state

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(state.names) { item ->
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("detail/${item.name}/${item.description}/${item.storage}/${item.processor}")
                        }
                        .fillMaxWidth()
                        .background(color = Color.Gray)
                        .padding(horizontal = 15.dp, vertical = 8.dp)
                ) {
                    Text(text = "Marca: ${item.name}", color = Color.White)
                    Text(text = "Descripcion:  ${item.description}", color = Color.White)
                    Text(text = "Almacenamiento: ${item.storage}", color = Color.White)
                    Text(text = "Procesador: ${item.processor}", color = Color.White)
                }
                Spacer(modifier = Modifier.padding(12.dp))
            }
        }
    }
}
