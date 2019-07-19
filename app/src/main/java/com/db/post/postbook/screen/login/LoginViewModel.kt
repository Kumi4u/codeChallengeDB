package com.db.post.postbook.screen.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.db.post.postbook.base.BaseViewModel

class LoginViewModel  : BaseViewModel() {




    lateinit var userIdMutableLiveData: MutableLiveData<String>

    fun init() {

        Log.e("kumi", "application " + PostBookApplication.getPostBookApplication())
      //  PostBookApplication.getPostBookApplication().userComponent.inject(this)
        initVariables()
    }


    fun onLoginClick(){

        userIdMutableLiveData.postValue("aegagag")

    }

    private fun initVariables() {

        userIdMutableLiveData = MutableLiveData()

    }}