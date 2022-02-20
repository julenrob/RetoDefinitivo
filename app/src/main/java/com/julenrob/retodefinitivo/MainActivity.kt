package com.julenrob.retodefinitivo

import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.julenrob.retodefinitivo.ui.theme.Navigation.AppNavigation
import com.julenrob.retodefinitivo.ui.theme.RetoDefinitivoTheme

private val images: List<Element> = listOf(
    Element(R.drawable.ic_launcher_foreground, "JetPack1", "This is a jetpack photo 1"),
    Element(R.drawable.ic_launcher_foreground, "JetPack2", "This is a jetpack photo 2"),
    Element(R.drawable.ic_launcher_foreground, "JetPack3", "This is a jetpack photo 3"),
    Element(R.drawable.ic_launcher_foreground, "JetPack4", "This is a jetpack photo 4"),
    Element(R.drawable.ic_launcher_foreground, "JetPack5", "This is a jetpack photo 5"),
    Element(R.drawable.ic_launcher_foreground, "JetPack6", "This is a jetpack photo 6"),
    Element(R.drawable.ic_launcher_foreground, "JetPack7", "This is a jetpack photo 7"),
    Element(R.drawable.ic_launcher_foreground, "JetPack8", "This is a jetpack photo 8")

    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetoDefinitivoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                    //Images(images)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview(){
    RetoDefinitivoTheme {

        // val scrollState = rememberScrollState()
        // Column(modifier = Modifier.verticalScroll(scrollState)) {
        Images(images)

        //}
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RetoDefinitivoTheme {
        AppNavigation()
    }
}