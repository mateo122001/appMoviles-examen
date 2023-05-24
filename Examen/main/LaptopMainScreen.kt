package com.mateodevs.crudroom

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mateodevs.crudroom.main.MainViewModel

@Composable
fun MainScreen(navController: NavController,viewModel: MainViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Ingreso de datos")})
        }
    ) {padding ->

        val state = viewModel.state
        Column(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .padding(10.dp, 50.dp, 10.dp, 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Nombre: Steven Mateo Parraga Coello ")
            Text(text = "Entidad: Laptop ")
            Text(text = "Curso: 7A")
            OutlinedTextField(value = state.name, onValueChange = { viewModel.onNameChange(it) }, label = { Text(
                text = "Ingrese el nombre"
            )})
            OutlinedTextField(value = state.description, onValueChange = { viewModel.onDescriptionChange(it) }, label = { Text(
                text = "Ingrese la descripcion"
            )})
            OutlinedTextField(value = state.storage.toString(), onValueChange = {viewModel.onStorageChange(it)}, label = { Text(
                text = "Ingrese el almacenamiento"
            )})
            OutlinedTextField(value = state.processor, onValueChange = {viewModel.onProcessorChange(it)}, label = { Text(
                text = "Ingrese el procesador"
            )})
            Button(onClick = { viewModel.saveLaptop() }) {
                Text(text = "Crear", fontSize = 18.sp)
            }

            Button(onClick = { navController.navigate("lista") }) {
                Text(text = "ver lista")
            }
        }
    }
}