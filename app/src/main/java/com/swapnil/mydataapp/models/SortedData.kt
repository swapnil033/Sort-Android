package com.swapnil.mydataapp.models

import com.google.gson.annotations.SerializedName

data class SortedData(
    val sort : ArrayList<Data1> = arrayListOf()
)

data class Data1(
    val mid : Int,
    val tidList : ArrayList<TidData> = arrayListOf()
)

data class TidData(
    val tid : Long,
    val sortNarration : ArrayList<Narration> = arrayListOf()
)

data class Narration(
    val amount : Double,
    val narration : Long
)