package com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow

import com.google.gson.annotations.SerializedName

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