package com.mateodevs.crudroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.mateodevs.crudroom.data.LaptopDatabase
import com.mateodevs.crudroom.data.LaptopRepository
import com.mateodevs.crudroom.main.LaptopScreen
import com.mateodevs.crudroom.main.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db=Room.databaseBuilder(this,LaptopDatabase::class.java, "Laptop6_db").build()
        val dao= db.dao
        val repository= LaptopRepository(dao)
        val viewmodel = MainViewModel(repository)

        //en setContent solo se coloca el MainScreen, de lo contrario marca error
        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "main" ){
                composable("main" ){

                    MainScreen(navController,viewmodel)

                }
                composable(route="detail"+"/{text}/{text2}/{text3}/{text4}", arguments =  listOf(navArgument(name = "text") {type= NavType.StringType }, (navArgument(name="text2") { type= NavType.StringType }),
                    (navArgument(name="text3"){
                        type= NavType.StringType }
                            ),
                    (navArgument(name="text4"){
                        type= NavType.StringType }
                            )
                        )
                    )
                {
                    DetailScreen(navController, it.arguments?.getString("text"),
                        it.arguments?.getString("text2"), it.arguments?.getString("text3"), it.arguments?.getString("text4"))
                }

                composable("lista"){
                    LaptopScreen(viewModel = viewmodel, navController =navController )
                }
            }
        }
    }
}


/*
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CrudRoomTheme {
        Greeting("Android")
    }
}

 */