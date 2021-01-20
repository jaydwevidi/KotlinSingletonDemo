package com.example.kotlinsingletondemo

import com.example.kotlinsingletondemo.Modles.User

object ExampleSingleton {

    val userObject : User by lazy {
        User("jayraj1999@gmail.com","Jay Dwivedi", "Batman.png")
    }
}