package com.oscar.interview_task.ui.dynamic_view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.Node

@Composable
fun InputTypeView(node: Node, keyboardType: KeyboardType, visualTransformation: VisualTransformation){


    var text by rememberSaveable { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(
                    node.meta.label.text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            },
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier.padding(8.dp)
        )
    }

}
