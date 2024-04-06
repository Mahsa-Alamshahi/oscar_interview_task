package com.oscar.interview_task.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oscar.interview_task.R


@Composable
fun HomeScreenRoute() {
    HomeScreen()
}


@Composable
fun HomeScreen() {


    Column(
        modifier= Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Welcome to Ory.",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp)

        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        )


    }

}