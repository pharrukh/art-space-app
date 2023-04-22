package com.normuradov.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.normuradov.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceFrame()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceFrame() {

    val imageId = R.drawable.pantry_seller
    val imageDescription = "Photograph shows two young boys, one holding a dish of pastries(?) and the other stirring something in a bowl."
    val imageTitle = "Zaravshan district. Samarkand. Pastry vendor"
    val imageAuthor = "-"
    val imageDate = "between 1865 and 1872"

    Column (
        modifier = Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Surface(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 20.dp)
            .shadow(elevation = 5.dp)
            .border(color = Color.Gray, width = 6.dp)
            .padding(40.dp)
        )
        {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = imageDescription,
                )
        }
        Box (
            modifier = Modifier
                .padding(10.dp)
                .shadow(1.dp)
                .padding(5.dp)
                .fillMaxWidth(0.8f)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = imageTitle,
                    fontFamily = FontFamily.Serif,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center)
                Text(text = "$imageAuthor ($imageDate)", fontFamily = FontFamily.Serif, fontSize = 15.sp,)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row (modifier = Modifier.padding(vertical = 10.dp)) {
            Button(onClick = { /*TODO*/ })
            {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Previous",
                    modifier = Modifier.size(50.dp)
                )
            }
            Spacer(modifier =  Modifier.width(10.dp))
            Button(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.ArrowForward,
                    contentDescription = "Next",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceFrame()
    }
}