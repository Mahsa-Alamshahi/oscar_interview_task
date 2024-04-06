package com.oscar.interview_task.ui.dynamic_view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.Node

@Composable
fun CheckViewType(nodes: List<Node>, onSubmitClick: (HashMap<String, String>) -> Unit) {

    val fieldValueHashMap: HashMap<String, String> = HashMap()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        items(nodes) { node ->

            if (node.type == "input") {

                when (node.attributes.type) {


                    "password" -> InputTypeView(
                        node = node,
                        keyboardType = KeyboardType.Password,
                        visualTransformation = PasswordVisualTransformation()
                    ) { key, value ->
                        fieldValueHashMap[key] = value
                    }


                    "email" -> InputTypeView(
                        node = node,
                        keyboardType = KeyboardType.Email,
                        visualTransformation = VisualTransformation.None
                    ) { key, value ->
                        fieldValueHashMap[key] = value
                    }


                    "text" -> InputTypeView(
                        node = node,
                        keyboardType = KeyboardType.Text,
                        visualTransformation = VisualTransformation.None
                    ) { key, value ->
                        fieldValueHashMap[key] = value
                    }


                    "submit" -> SubmitViewType(node = node,
                        onGetValue = { key, value ->
                            fieldValueHashMap[key] = value
                        }) {
                        onSubmitClick(fieldValueHashMap)
                    }


                    "hidden" -> {}

                    else -> {
                        InputTypeView(
                            node = node,
                            keyboardType = KeyboardType.Text,
                            visualTransformation = VisualTransformation.None
                        ) { key, value ->
                            fieldValueHashMap[key] = value
                        }
                    }
                }


            } else if (node.type == "text") {
                TextViewType(node = node)
            } else {
                Text("")
            }

        }

    }

}