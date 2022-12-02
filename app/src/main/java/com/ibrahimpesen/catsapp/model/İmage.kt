package com.ibrahimpesen.catsapp.model


import androidx.room.ColumnInfo
import androidx.room.Entity

import com.google.gson.annotations.SerializedName


data class İmage(

    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?,

    )