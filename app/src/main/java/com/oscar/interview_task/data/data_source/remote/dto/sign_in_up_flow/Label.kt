package com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow

import com.google.gson.annotations.SerializedName

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