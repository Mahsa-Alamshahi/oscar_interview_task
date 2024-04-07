package com.oscar.interview_task.data.data_source.remote.dto.authentication_response

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class Context(
    @SerializedName("reason")
    val reason: String,
//    @SerializedName("actual_length")
//    val actualLength: Int,
//    @SerializedName("min_length")
//    val minLength: Int
)