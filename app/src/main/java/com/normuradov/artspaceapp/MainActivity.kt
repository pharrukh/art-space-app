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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.normuradov.artspaceapp.ui.theme.ArtSpaceAppTheme


val Images = listOf<ArtImage>(
    ArtImage(id = "pantry_seller",
        title = "Zaravshan district. Samarkand. Pastry vendor",
        author = "unknown",
        date = "between 1865 and 1872",
        description = "Photograph shows two young boys, one holding a dish of pastries(?) and the other stirring something in a bowl."
    ),
    ArtImage(id = "shirdor_court",
        title = "In the court of Shir-Dor mosque. Samarkand",
        author = "Prokudin-Gorskiĭ",
        date = "between 1905 and 1915",
        description = "Boy seated in courtyard of mosque."
    ),
    ArtImage(id = "karagach",
        title = "Karagachi. Samarkand",
        author = "Prokudin-Gorskiĭ",
        date = "between 1905 and 1915",
        description = "A tree in a field."
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceFrame(Images)
                }
            }
        }
    }
}

@Composable
fun ArtSpaceFrame(images: List<ArtImage>) {
    var pointer by remember { mutableStateOf(2) }
    val image = images[pointer]

    val context = LocalContext.current
    val imageId = context.resIdByName(image.id)
    val imageDescription = image.description
    val imageTitle = image.title
    val imageAuthor = image.author
    val imageDate = image.date

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
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = imageTitle,
                    fontFamily = FontFamily.Serif,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center)
                Text(buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 15.sp)) {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(imageAuthor)
                        }
                        append(" ($imageDate)")
                    }
                })
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row (modifier = Modifier.padding(vertical = 10.dp)) {
            Button(onClick = { if(pointer === 0) pointer = Images.size -1 else pointer-- })
            {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Previous",
                    modifier = Modifier.size(50.dp)
                )
            }
            Spacer(modifier =  Modifier.width(10.dp))
            Button(onClick = { if(pointer === Images.size - 1) pointer = 0 else pointer++ }) {
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
        ArtSpaceFrame(Images)
    }
}