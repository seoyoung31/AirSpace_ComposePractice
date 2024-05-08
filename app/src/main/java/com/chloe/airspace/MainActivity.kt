package com.chloe.airspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chloe.airspace.ui.theme.AirSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirSpaceTheme {
                // A surface container using the 'background' color from the theme
                    SpaceApp()
                }
            }
        }
    }
@Composable
fun ImageAndButton(
    drawableResourceId : Int,
    imageTitle : Int,
    imageDescription : Int,
    onPreviousClick : () -> Unit,
    onNextClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
        ) {
            Card(
                modifier = Modifier
                    .background(Color(0xFFFFFFFF), shape = RectangleShape)
                    .size(width = 350.dp, height = 350.dp)
                    .shadow(
                        elevation = 20.dp,
                        shape = RectangleShape,
                        ambientColor = DefaultShadowColor,
                        spotColor = DefaultShadowColor
                    )
                    .padding(top = 20.dp)
            ) {

            }
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(imageTitle),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(280.dp)
                    .height(320.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(
            modifier = Modifier
            .height(15.dp)
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .background(color = Color(0xFFD5D5D5))
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
            ) {
                Text(
                    text = stringResource(imageTitle),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(horizontal = 10.dp)
                        .padding(top = 10.dp),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = stringResource(imageDescription),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(bottom = 10.dp)
                        .align(Alignment.Start),
                    fontWeight = FontWeight.Bold
                )
        }
        }
        Spacer(
            modifier = Modifier
                .height(1.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onPreviousClick,
                shape = RoundedCornerShape(23.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF3163C9),
                ),
                modifier = Modifier
                    .size(150.dp, 40.dp)

            ) {
                Text(
                    text = stringResource(R.string.previous_button_text),
                    fontSize = 15.sp
                )
            }
            Button(
                onClick = onNextClick,
                shape = RoundedCornerShape(23.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF3163C9)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
                modifier = Modifier
                    .size(150.dp, 40.dp)
            ) {
                Text(
                    text = stringResource(R.string.next_button_text),
                    fontSize = 15.sp
                )
            }
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceApp(modifier: Modifier = Modifier) {

    var currentImage by remember { mutableStateOf(1) }

    val imageResource = when (currentImage) {
        1 -> R.drawable.happiness1
        2 -> R.drawable.happiness2
        3 -> R.drawable.happiness3
        4 -> R.drawable.happiness4
        else -> R.drawable.happiness5
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Happiness",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentImage) {
                1 -> {
                    ImageAndButton(
                        drawableResourceId = R.drawable.happiness1,
                        imageTitle = R.string.happiness1_image_title,
                        imageDescription = R.string.happiness1_image_description,
                        onPreviousClick = { currentImage = 5 },
                        onNextClick = { currentImage = 2 }
                    )

                }
                2 -> {
                    ImageAndButton(
                        drawableResourceId = R.drawable.happiness2,
                        imageTitle = R.string.happiness2_image_title,
                        imageDescription = R.string.happiness2_image_description,
                        onPreviousClick = { currentImage = 1 },
                        onNextClick = { currentImage = 3 })
                }
                3 -> {
                    ImageAndButton(
                        drawableResourceId = R.drawable.happiness3,
                        imageTitle = R.string.happiness3_image_title,
                        imageDescription = R.string.happiness3_image_description,
                        onPreviousClick = { currentImage = 2},
                        onNextClick = { currentImage = 4 }
                    )
                }
                4 -> {
                    ImageAndButton(
                        drawableResourceId = R.drawable.happiness4,
                        imageTitle = R.string.happiness4_image_title,
                        imageDescription = R.string.happiness4_image_description,
                        onPreviousClick = { currentImage = 3 },
                        onNextClick = { currentImage = 5 }
                    )
                }
                5 -> {
                    ImageAndButton(
                        drawableResourceId = R.drawable.happiness5,
                        imageTitle = R.string.happiness5_image_title,
                        imageDescription = R.string.happiness5_image_description,
                        onPreviousClick = { currentImage = 4 },
                        onNextClick = { currentImage = 1 })
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun AirSpacePreview() {
    AirSpaceTheme {
        SpaceApp()
    }
}
