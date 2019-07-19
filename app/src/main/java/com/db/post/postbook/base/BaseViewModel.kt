package com.db.post.postbook.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.KoinComponent

open class BaseViewModel : ViewModel(), KoinComponent {
    val compositeDisposable = CompositeDisposable()

    protected fun addToCompositeDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}