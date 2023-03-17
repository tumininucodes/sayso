package com.tumininu.sayso.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {

    val openedDocument = MutableLiveData<Boolean>(false)
    var currentRead: String? = null

}