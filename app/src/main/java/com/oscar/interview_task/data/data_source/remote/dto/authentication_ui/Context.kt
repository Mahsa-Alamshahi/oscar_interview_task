package com.oscar.interview_task.data.data_source.remote.dto.authentication_ui

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class Context(
    @SerializedName("title")
    val title: String
)