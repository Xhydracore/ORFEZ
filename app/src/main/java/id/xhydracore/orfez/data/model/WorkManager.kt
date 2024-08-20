package id.xhydracore.orfez.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class WorkManager(
    val id: Int? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    val state: Boolean? = false,
    @SerialName("time_span_day")
    val timeSpanDay: Int? = null,
)