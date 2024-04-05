package com.oscar.interview_task.ui.dynamic_view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow.Node

@Composable
fun TextViewType(node: Node){

    Text(text = node.meta.label.text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        style = TextStyle(
            Color.DarkGray
        ),
        modifier= Modifier.fillMaxWidth())

}



@Composable
@Preview
fun PreviewTextViewType(){

    Text("text = node.meta.label.text",
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        style = TextStyle(
            Color.DarkGray
        ),
        modifier= Modifier.fillMaxWidth()
    )
}