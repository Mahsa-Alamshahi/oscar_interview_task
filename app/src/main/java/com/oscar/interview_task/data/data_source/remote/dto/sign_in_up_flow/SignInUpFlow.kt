package com.oscar.interview_task.data.data_source.remote.dto.sign_in_up_flow

import com.google.gson.annotations.SerializedName

data class SignInUpFlow(
    @SerializedName("expires_at")
    val expires_at: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("issued_at")
    val issued_at: String,
    @SerializedName("organization_id")
    val organization_id: Any,
    @SerializedName("request_url")
    val request_url: String,
    @SerializedName("session_token_exchange_code")
    val session_token_exchange_code: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("ui")
    val ui: Ui
)