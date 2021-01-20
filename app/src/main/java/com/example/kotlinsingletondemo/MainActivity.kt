package com.example.kotlinsingletondemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.kotlinsingletondemo.ui.MainViewModle
import com.example.kotlinsingletondemo.ui.MyViewFinder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Singleton value is   :  " + ExampleSingleton.userObject)
        println("Singleton address is :  " + ExampleSingleton.userObject.hashCode())
        //hashcode will be same even when recreating the activity
        //to restart onCreate or reCreate Activity rotate the screen ;)

        val mainViewModle : MainViewModle by viewModels()

        mainViewModle.user.observe(this, Observer {
            Log.d(TAG, "newUID: $it")
        })

        mainViewModle.changeUserID("1")


        val myViewFinder:MyViewFinder by viewModels()

    }
}