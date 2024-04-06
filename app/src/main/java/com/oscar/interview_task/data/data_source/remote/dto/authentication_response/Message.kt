package com.oscar.interview_task.data.data_source.remote.dto.authentication_response

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class Message(
    @SerializedName("context")
    val context: Context,
    @SerializedName("id")
    val id: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)