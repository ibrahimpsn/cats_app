package com.ibrahimpesen.catsapp.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CatsItem(
    @ColumnInfo(name ="adaptability")
    @SerializedName("adaptability")
    val adaptability: Int?,
    @ColumnInfo(name = "affection_level")
    @SerializedName("affection_level")
    val affectionLevel: Int?,
    @ColumnInfo(name = "alt_names")
    @SerializedName("alt_names")
    val altNames: String?,
    @ColumnInfo(name="bidability")
    @SerializedName("bidability")
    val bidability: Int?,
    @ColumnInfo(name="cat_friendly")
    @SerializedName("cat_friendly")
    val catFriendly: Int?,
    @ColumnInfo(name="cfa_url")
    @SerializedName("cfa_url")
    val cfaUrl: String?,
    @ColumnInfo(name="child_friendly")
    @SerializedName("child_friendly")
    val childFriendly: Int?,
    @ColumnInfo(name="country_code")
    @SerializedName("country_code")
    val countryCode: String?,
    @ColumnInfo(name="country_codes")
    @SerializedName("country_codes")
    val countryCodes: String?,
    @ColumnInfo(name="description")
    @SerializedName("description")
    val description: String?,
    @ColumnInfo(name="dog_friendly")
    @SerializedName("dog_friendly")
    val dogFriendly: Int?,
    @ColumnInfo(name="energy_level")
    @SerializedName("energy_level")
    val energyLevel: Int?,
    @ColumnInfo(name="experimental")
    @SerializedName("experimental")
    val experimental: Int?,
    @ColumnInfo(name="grooming")
    @SerializedName("grooming")
    val grooming: Int?,
    @ColumnInfo(name="hairless")
    @SerializedName("hairless")
    val hairless: Int?,
    @ColumnInfo(name="health_issues")
    @SerializedName("health_issues")
    val healthİssues: Int?,
    @ColumnInfo(name="hypoallergenic")
    @SerializedName("hypoallergenic")
    val hypoallergenic: Int?,
    @ColumnInfo(name="id")
    @SerializedName("id")
    val id: String?,
    @ColumnInfo(name="image")
    @SerializedName("image")
    val image: İmage?,
    @ColumnInfo(name="indoor")
    @SerializedName("indoor")
    val indoor: Int?,
    @ColumnInfo(name="intelligence")
    @SerializedName("intelligence")
    val intelligence: Int?,
    @ColumnInfo(name="lap")
    @SerializedName("lap")
    val lap: Int?,
    @ColumnInfo(name="life_span")
    @SerializedName("life_span")
    val lifeSpan: String?,
    @ColumnInfo(name="name")
    @SerializedName("name")
    val name: String?,
    @ColumnInfo(name="natural")
    @SerializedName("natural")
    val natural: Int?,
    @ColumnInfo(name="origin")
    @SerializedName("origin")
    val origin: String?,
    @ColumnInfo(name="rare")
    @SerializedName("rare")
    val rare: Int?,
    @ColumnInfo(name="reference_image_id")
    @SerializedName("reference_image_id")
    val referenceİmageİd: String?,
    @ColumnInfo(name="rex")
    @SerializedName("rex")
    val rex: Int?,
    @ColumnInfo(name="shedding_level")
    @SerializedName("shedding_level")
    val sheddingLevel: Int?,
    @ColumnInfo(name="short_legs")
    @SerializedName("short_legs")
    val shortLegs: Int?,
    @ColumnInfo(name="social_needs")
    @SerializedName("social_needs")
    val socialNeeds: Int?,
    @ColumnInfo(name="stranger_friendly")
    @SerializedName("stranger_friendly")
    val strangerFriendly: Int?,
    @ColumnInfo(name="suppressed_tail")
    @SerializedName("suppressed_tail")
    val suppressedTail: Int?,
    @ColumnInfo(name="temperament")
    @SerializedName("temperament")
    val temperament: String?,
    @ColumnInfo(name="vcahospitals-url")
    @SerializedName("vcahospitals_url")
    val vcahospitalsUrl: String?,
    @ColumnInfo(name="vetstreet_url")
    @SerializedName("vetstreet_url")
    val vetstreetUrl: String?,
    @ColumnInfo(name="vocalisation")
    @SerializedName("vocalisation")
    val vocalisation: Int?,
    @ColumnInfo(name="weight")
    @SerializedName("weight")
    val weight: Weight?,
    @ColumnInfo(name="wikipedia_url")
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String?,
    /*@Ignore
    @ColumnInfo(name ="isSelected")
    var isSelected : Boolean?=false*/

){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0



}