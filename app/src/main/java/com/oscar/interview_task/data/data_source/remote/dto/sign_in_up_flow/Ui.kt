package com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow

import com.google.gson.annotations.SerializedName

data class Ui(
    @SerializedName("action")
    val action: String,
    @SerializedName("method")
    val method: String,
    @SerializedName("nodes")
    val nodes: List<Node>
)