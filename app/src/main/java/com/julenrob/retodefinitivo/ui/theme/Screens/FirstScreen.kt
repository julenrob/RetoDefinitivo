package com.julenrob.retodefinitivo.ui.theme.Screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.julenrob.retodefinitivo.Element
import com.julenrob.retodefinitivo.R
import com.julenrob.retodefinitivo.ui.theme.Navigation.AppScreens

private val images: List<Element> = listOf(
    Element(R.drawable.ic_launcher_foreground, "JetPack1", "This is a jetpack photo 1"),
    Element(R.drawable.ic_launcher_foreground, "JetPack2", "This is a jetpack photo 2"),
    Element(R.drawable.ic_launcher_foreground, "JetPack3", "This is a jetpack photo 3"),
    Element(R.drawable.ic_launcher_foreground, "JetPack4", "This is a jetpack photo 4"),
    Element(R.drawable.ic_launcher_foreground, "JetPack5", "This is a jetpack photo 5"),
    Element(R.drawable.ic_launcher_foreground, "JetPack6", "This is a jetpack photo 6"),
    Element(R.drawable.ic_launcher_foreground, "JetPack7", "This is a jetpack photo 7"),
    Element(R.drawable.ic_launcher_foreground, "JetPack8", "This is a jetpack photo 8"),
    Element(R.drawable.ic_launcher_foreground, "JetPack9", "This is a jetpack photo 9"),
    Element(R.drawable.ic_launcher_foreground, "JetPack10", "This is a jetpack photo 10"),
    Element(R.drawable.ic_launcher_foreground, "JetPack11", "This is a jetpack photo 11"),
    Element(R.drawable.ic_launcher_foreground, "JetPack12", "This is a jetpack photo 12"),
    Element(R.drawable.ic_launcher_foreground, "JetPack13", "This is a jetpack photo 13"),
    Element(R.drawable.ic_launcher_foreground, "JetPack14", "This is a jetpack photo 14"),
    Element(R.drawable.ic_launcher_foreground, "JetPack15", "This is a jetpack photo 15"),
    Element(R.drawable.ic_launcher_foreground, "JetPack16", "This is a jetpack photo 16")

)

@Composable
fun FirstScreen(navController: NavController){
    Scaffold{
        FirstBodyContent(navController)
    }
}

@Composable
fun FirstBodyContent(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Text("Primera Screen")
        // Button(onClick ={
        //    navController.navigate(route = AppScreens.SecondScreen.route)
        //}){
        //    Text("Volver atrás.")
        //}
        // Images(images)
        PhotoGrid(images, navController)

    }
}

data class Element(val image: Int, val title:String, val description:String)

@Composable
fun Images(elements:List<Element>) {
    LazyColumn {
        items(elements){ element ->
            Component(element)
        }
    }
}

@Composable
fun Component(element: Element) {
    Column(){
        MyImage(element.image)
        MyText(element.description)
    }
}

@Composable
fun MyImage(image:Int){
    Image(
        painterResource(image),
        ""
    )
}

@Composable
fun MyText(text:String){
    Text(text)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoGrid(images: List<Element>, navController: NavController) {
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier
            .border(BorderStroke(10.dp, Color.Black))
            .fillMaxWidth()

    ) {
        items(images) {
            Surface(modifier = Modifier.clickable { navController.navigate(route = AppScreens.SecondScreen.route +
                    it.title +
                    it.description +
                    it.image
                    //it
            ) }) {
                MyImage(it.image)
            }

        }
    }
}
