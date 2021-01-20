package com.example.kotlinsingletondemo.repository

import androidx.lifecycle.LiveData
import com.example.kotlinsingletondemo.Modles.User
import com.example.kotlinsingletondemo.api.MyRetrofitBuilder
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MyRepository {

    var job: CompletableJob? = null

    fun getUser(userID: String):LiveData<User>{
        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(IO +it).launch {
                        val user = MyRetrofitBuilder.apiService.getUser(userID)
                        withContext(Main){
                            value = user
                            it.complete()
                        }
                    }
                }
            }
        }
    }
    fun cancelJobs(){
        job?.cancel()
    }

}