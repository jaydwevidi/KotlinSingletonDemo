package com.example.kotlinsingletondemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kotlinsingletondemo.Modles.User
import com.example.kotlinsingletondemo.repository.MyRepository

class MainViewModle: ViewModel(){
    val _userID = MutableLiveData<String>()

    val user:LiveData<User> = Transformations.switchMap(_userID){
        MyRepository.getUser(it)
    }

    fun changeUserID(newUserID: String){
        if (_userID.value != newUserID){
            _userID.value = newUserID
        }
    }

    fun cancleJob(){
        MyRepository.cancelJobs()
    }
}