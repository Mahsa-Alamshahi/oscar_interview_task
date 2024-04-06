package com.oscar.interview_task.data.data_source.remote.dto.authentication_response

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName


@Stable
data class Attributes(
    @SerializedName("autocomplete")
    val autocomplete: String,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("node_type")
    val nodeType: String,
    @SerializedName("required")
    val required: Boolean,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)