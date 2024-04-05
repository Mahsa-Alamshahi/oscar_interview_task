package com.oscar.interview_task.ui.view_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.oscar.interview_task.R
import com.oscar.interview_task.ui.view_components.AnimationLoader

@Composable
fun ErrorView(message: String){


    val heightInDp = LocalConfiguration.current.screenHeightDp.dp

    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        AnimationLoader(resId = R.raw.error,
            height = heightInDp /2)

       Text(message)
    }
}