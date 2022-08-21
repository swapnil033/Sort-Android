package com.swapnil.mydataapp.helpers

import android.content.Context
import com.google.gson.Gson
import com.swapnil.mydataapp.models.InputData
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets

private fun Context.getJson(path: String) : String{
    var jsonString = "";

    try {
        val inputStream : InputStream = this.assets.open(path)

        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        jsonString = String(buffer, StandardCharsets.UTF_8)

    } catch (e : Exception){
        e.printStackTrace()
    }

    return jsonString
}

fun Context.getInput() : InputData {

    return Gson().fromJson(this.getJson("json/input.json"), InputData::class.java)
}