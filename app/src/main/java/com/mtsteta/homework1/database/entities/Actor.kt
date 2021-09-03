package com.mtsteta.homework1.database.entities

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "actors")
data class Actor(
    @SerializedName("adult")
    val adult: Boolean,

    @SerializedName("gender")
    val gender: Int,

    @SerializedName("id")
    @PrimaryKey
    val id: Long,

    @SerializedName("known_for_department")
    val knownForDepartment: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("original_name")
    val originalName: String,

    @SerializedName("popularity")
    val popularity: Number,

    @SerializedName("profile_path")
    val profilePath: String,

    @SerializedName("cast_id")
    val castId: Int,

    @SerializedName("character")
    val character: String,

    @SerializedName("credit_id")
    val creditId: String,

    @SerializedName("order")
    val order: Int,
)
