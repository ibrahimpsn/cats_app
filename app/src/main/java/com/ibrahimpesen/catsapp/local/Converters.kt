package com.ibrahimpesen.catsapp.local
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ibrahimpesen.catsapp.model.Weight
import com.ibrahimpesen.catsapp.model.İmage



class Converters {


    @TypeConverter
    fun toImageProfileData(value: String?): İmage? {
        return Gson().fromJson(value, İmage::class.java)
    }

    @TypeConverter
    fun fromImageProfileData(value: İmage?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toWeightProfileData(value: String?): Weight? {
        return Gson().fromJson(value, Weight::class.java)
    }

    @TypeConverter
    fun fromWeightProfileData(value: Weight?): String? {
        return Gson().toJson(value)
    }



}