package com.oscar.interview_task.ui.dynamic_view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.Node

@Composable
fun SubmitViewType(node: Node,
                   onGetValue:(String, String) -> Unit,
                   onClick: () -> Unit) {



    Button(
        onClick = {
            onGetValue(node.attributes.name, node.attributes.value)
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(16)
    ) {
        Text(text = node.meta.label.text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium)
    }
}

