package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SpaceArtScreen()
                }
            }
        }
    }
}

@Composable
fun SpaceArtScreen() {
    var currentArtWork by remember {
        mutableStateOf(1)
    }
    var image = R.drawable.picture1
    var title = "La noche estrellada"
    var artist = "van Gogh"
    var year = "1889"
    when(currentArtWork) {
        1 -> {
            image = R.drawable.picture1
            title = "La noche estrellada"
            artist = "van Gogh"
            year = "1889"
        }
        2 -> {
            image = R.drawable.picture2
            title = "Las meninas"
            artist = "Velázquez"
            year = "1656"
        }
        3 -> {
            image = R.drawable.picture3
            title = "La joven de la perla"
            artist = "Vermeer"
            year = "1665"
        }
        4 -> {
            image = R.drawable.picture4
            title = "El Sena en la Grande Jatte"
            artist = "Seurat"
            year = "1888"
        }
        5 -> {
            image = R.drawable.picture5
            title = "Place des Lices"
            artist = "Signac"
            year = "1893"
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3F)
                .wrapContentSize(align = Alignment.Center),
            elevation = 16.dp,
            border = BorderStroke(1.dp, color = Color.DarkGray)
        ) {
            Image(
                modifier = Modifier.padding(32.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier.weight(1F),
        ) {

            Surface(
                elevation = 16.dp) {
                SpaceArtwork(
                    title = title,
                    artist = artist,
                    year = year,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterHorizontally)
            ){
                Button(
                    modifier = Modifier.padding(8.dp).weight(1F),
                    onClick = { if(currentArtWork == 1) currentArtWork = 5 else currentArtWork-- }) {
                    Text(text = "Previous")
                }

                Button(
                    modifier = Modifier.padding(8.dp).weight(1F),
                    onClick = { if(currentArtWork == 5) currentArtWork = 1 else currentArtWork++ }) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Composable
fun SpaceArtwork(title: String, artist: String, year: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
    ) {
        Text(text = title, fontSize = 25.sp, fontWeight = FontWeight.Light)
        Row {
            Text(text = artist, fontWeight = FontWeight.Bold)
            Text(text = " (", fontWeight = FontWeight.Light)
            Text(text = year, fontWeight = FontWeight.Light)
            Text(text = ")", fontWeight = FontWeight.Light)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        SpaceArtScreen()
    }
}