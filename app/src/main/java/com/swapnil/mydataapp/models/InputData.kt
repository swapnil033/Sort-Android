package com.swapnil.mydataapp.models

import com.google.gson.annotations.SerializedName

data class InputData(
    @SerializedName("sort") val sort : ArrayList<Data>
    )

data class Data(
    @SerializedName("Mid") val mid : Int,
    @SerializedName("Tid") val tid : Long,
    @SerializedName("amount") val amount : Double,
    @SerializedName("narration") val narration : Long
)