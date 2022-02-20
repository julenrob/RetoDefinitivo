package com.julenrob.retodefinitivo.ui.theme.Screens

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController, title: String?, description: String?, image: Int) {
    Scaffold{
        SecondBodyContent(navController, title, description, image)
    }
}

@Composable
fun SecondBodyContent(navController: NavController, title: String?, description: String?, image: Int){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("El titulo era $title")
        Text("La descripción era $description")
        Image(
            painterResource(image),
            ""

        )
    }
}