package com.oscar.interview_task.data.data_source.remote.dto.authentication_response

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName


@Stable
data class Node(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("group")
    val group: String,
    @SerializedName("messages")
    val messages: List<Any>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("type")
    val type: String
)