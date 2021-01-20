package com.example.kotlinsingletondemo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewFinder: ViewModel() {
    fun getLiveData() = MutableLiveData<List<Int>>()
}