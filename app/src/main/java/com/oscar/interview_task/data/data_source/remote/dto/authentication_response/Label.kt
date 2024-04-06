package com.oscar.interview_task.data.data_source.remote.dto.authentication_response

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName
import com.oscar.interview_task.data.data_source.remote.dto.authentication_ui.Context

@Stable
data class Label(
    @SerializedName("context")
    val context: Context,
    @SerializedName("id")
    val id: Int,
    @SerializedName("text")
    val text: String,
    @SerializedName("type")
    val type: String
)