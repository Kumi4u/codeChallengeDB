package com.db.post.postbook.base

import androidx.lifecycle.ViewModel
import com.db.post.postbook.navigation.Navigation
import com.db.post.postbook.navigation.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {
    val compositeDisposable = CompositeDisposable()
    val navigateLiveData : SingleLiveEvent<Navigation> =
        SingleLiveEvent()


    protected fun addToCompositeDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    protected fun navigate(navigation: Navigation){
        navigateLiveData.postValue(navigation)
    }

}