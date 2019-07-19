package com.db.post.postbook.screen.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.db.post.postbook.base.BaseViewModel
import com.db.post.postbook.restServices.retro.PostBookRestInterface
import io.reactivex.schedulers.Schedulers
import org.koin.core.inject

class LoginViewModel : BaseViewModel() {

    val postBookRestInterface: PostBookRestInterface by inject()

    val userIdMutableLiveData = MutableLiveData<String>()


    fun onLoginClick() {


        val disposable = postBookRestInterface.getUserData(userIdMutableLiveData.value ?: "")
            .subscribeOn(Schedulers.io()).subscribe({ user ->
                navigate(LoginNavigation.ToPosts(user))

            }, { throwable ->
                Log.e("Kumi", "error is ", throwable)
            })



        addToCompositeDisposable(disposable)


    }
}