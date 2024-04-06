package com.oscar.interview_task.data.data_source.remote.dto.authentication_ui

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class Ui(
    @SerializedName("action")
    val action: String,
    @SerializedName("method")
    val method: String,
    @SerializedName("nodes")
    val nodes: List<Node>
)