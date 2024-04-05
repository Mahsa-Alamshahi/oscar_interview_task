package com.oscar.interview_task.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oscar.interview_task.R


@Composable
fun HomeScreenRoute(
    onSignUpNavigation: () -> Unit,
    onSignInNavigation: () -> Unit,
) {

    HomeScreen(
        onSignUpNavigation, onSignInNavigation
    )
}

@Composable
fun HomeScreen(onSignUpNavigation: () -> Unit, onSignInNavigation: () -> Unit) {


    val customCardElevation = CardDefaults.cardElevation(
        defaultElevation = 32.dp
    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Box(
            modifier = Modifier.weight(1f)
        ) {

        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
                .clickable {
                    onSignUpNavigation()
                },
            elevation = customCardElevation,
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            border = BorderStroke(
                2.dp, Brush.linearGradient(
                    colors = listOf(
                        Color.DarkGray,
                        Color.Blue,
                        Color.Magenta,
                        Color.Gray,
                        Color.Green,
                        Color.Red
                    )
                )
            )
        ) {


            Image(
                painter = painterResource(id = R.drawable.sign_up),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            )

        }



        Card(
            elevation = customCardElevation,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
                .clickable {
                    onSignInNavigation()
                },
            shape = RoundedCornerShape(22.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            border = BorderStroke(
                2.dp, Brush.linearGradient(
                    colors = listOf(
                        Color.Blue,
                        Color.Magenta,
                        Color.DarkGray,
                        Color.Green,
                        Color.Gray,
                        Color.Red
                    )
                )
            )
        ) {


            Image(
                painter = painterResource(id = R.drawable.signin),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

        }

    }
}


@Composable
@Preview
fun previ() {

    HomeScreen(onSignUpNavigation = { }) {

    }
}