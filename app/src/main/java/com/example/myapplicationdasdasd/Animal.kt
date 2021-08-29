package com.example.myapplicationdasdasd

import android.util.Log

val TAG = "Munji"
open class Animal (var age: Int, var gender: String, var name: String){
    fun soom(){
        Log.d(TAG,"${name}가 숨을 쉰다")
    }
    fun act(){
        Log.d(TAG,"${name}가 움직인다")
    }
    open fun eat(food:String){
        Log.d(TAG,"${name}가 ${food}를 먹는다")
    }

}

class Person (age: Int, gender: String, pName: String, num: String, nation: String):Animal(age, gender, pName){
    override fun eat(food: String) {
//        super.eat(food)
        Log.d(TAG,"${name}가 ${food}를 맛있게 먹는다")

    }

}