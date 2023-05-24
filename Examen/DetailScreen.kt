package com.mateodevs.crudroom

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mateodevs.crudroom.main.MainViewModel

@Composable
fun DetailScreen(navController: NavHostController, texto:String?, texto2: String?, texto3:String?, texto4: String?) {
    //  val state=viewModel.state

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Consulta individual de un registro") }
        )
    }) { padding ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center

            ) {

                Text(
                    text = "Marca: ${texto}",
                    style = MaterialTheme.typography.h6
                )
                //Spacer(modifier = Modifier.padding(12.dp))
                Text(
                    text = "Descripcion: ${texto2}",
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Storage: ${texto3}",
                    style = MaterialTheme.typography.h6
                )

                Text(
                    text = "Processor: ${texto4}",
                    style = MaterialTheme.typography.h6
                )

                /* Button(onClick = { navController.navigate("lista")},
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Regresar")
        }

        */

            }
        }

    }
}