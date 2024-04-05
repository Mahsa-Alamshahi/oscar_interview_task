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
import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.Node

@Composable
fun CheckViewType(nodes: List<Node>) {

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
                    )

                    "email" -> InputTypeView(
                        node = node,
                        keyboardType = KeyboardType.Email,
                        visualTransformation = VisualTransformation.None
                    )

                    "text" -> InputTypeView(
                        node = node,
                        keyboardType = KeyboardType.Text,
                        visualTransformation = VisualTransformation.None
                    )

                    "submit" -> SubmitViewType(node = node) {}
                    "hidden" -> {}
                    else -> {
                        InputTypeView(
                            node = node,
                            keyboardType = KeyboardType.Text,
                            visualTransformation = VisualTransformation.None
                        )
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