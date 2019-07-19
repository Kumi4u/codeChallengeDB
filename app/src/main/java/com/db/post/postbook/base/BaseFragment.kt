package com.db.post.postbook.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

abstract class BaseFragment : Fragment() {

    abstract fun getViewModel(): BaseViewModel
    abstract fun doDataBinding(inflater: LayoutInflater, container: ViewGroup?): ViewDataBinding

    var baseActivity: BaseActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity = context as BaseActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewDataBinding = doDataBinding(inflater, container)
        viewDataBinding.lifecycleOwner = this@BaseFragment

        val baseViewModel = getViewModel()

        baseViewModel.navigateLiveData.observe(this@BaseFragment, Observer {
            baseActivity?.navigationHandler?.onChanged(it.navigationCommand)
        })

        return viewDataBinding.root
    }


    override fun onDetach() {
        super.onDetach()
        baseActivity = null
    }


}