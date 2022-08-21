package com.swapnil.mydataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.swapnil.mydataapp.adapters.InputAdapter
import com.swapnil.mydataapp.databinding.ActivityMainBinding
import com.swapnil.mydataapp.helpers.getInput
import com.swapnil.mydataapp.models.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var sortedData : SortedData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setData(this.getInput())

        binding.adapter = InputAdapter(this, sortedData.sort)

    }

    private fun setData(inputJson: InputData) {
        sortedData = SortedData()
        for ( data in inputJson.sort){
            checkData(data, sortedData)
        }
    }

    private fun checkData(data: Data, sortedData: SortedData) {

        sortedData.sort.forEachIndexed { index, item ->
            if(item.mid == data.mid) {
                checkTid(data, index)
                return
            }
        }

        val narrationList = arrayListOf<Narration>()
        narrationList.add(Narration(data.amount, data.narration))

        val list = arrayListOf<TidData>()
        list.add(TidData(data.tid, narrationList))

        this.sortedData.sort.add(Data1(data.mid, list))
    }

    private  fun checkTid(data: Data, index: Int) {

        sortedData.sort[index].tidList.forEachIndexed { i, tidData ->
            if(tidData.tid == data.tid) {
                setNarration(data, index, i)
                return
            }
        }

        val narrationList = arrayListOf<Narration>()
        narrationList.add(Narration(data.amount, data.narration))

        sortedData.sort[index].tidList.add(TidData(data.tid, narrationList))
    }

    private fun setNarration(data: Data, index: Int, i: Int) {
        sortedData.sort[index].tidList[i].sortNarration.add(Narration(data.amount, data.narration))
    }

}