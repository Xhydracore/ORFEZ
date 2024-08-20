package id.xhydracore.orfez.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Parameter(
    val id: Int? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    val temperature: Float? = null,
    val humidity: Float? = null,
    val pH:Float? = null
)