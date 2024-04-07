package com.oscar.interview_task.data.data_source.remote.dto.authentication_response

import androidx.compose.runtime.Stable
import com.google.gson.annotations.SerializedName

@Stable
data class AuthenticationResponse(
    @SerializedName("expires_at")
    val expiresAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("issued_at")
    val issuedAt: String,
    @SerializedName("organization_id")
    val organizationId: Any,
    @SerializedName("request_url")
    val requestUrl: String,
    @SerializedName("session_token_exchange_code")
    val sessionTokenExchangeCode: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("ui")
    val ui: Ui,
//    @SerializedName("session_token")
//    val sessionToken: String


)