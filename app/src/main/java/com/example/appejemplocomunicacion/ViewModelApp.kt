package com.example.appejemplocomunicacion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelApp: ViewModel() {

    private val _navigation = MutableLiveData<Boolean>()
    val navigation: LiveData<Boolean> = _navigation

    private val _navigationToFirstFragment = MutableLiveData<Boolean>()
    val navigationToFirstFragment: LiveData<Boolean> = _navigationToFirstFragment

    private val _createNewActivity = MutableLiveData<Boolean>()
    val createNewActivity: LiveData<Boolean> = _createNewActivity

    fun navigation(){
        _navigation.postValue(true)
    }

    fun navigationToFirstFragment(){
        _navigationToFirstFragment.postValue(true)
    }

    fun createNewActivity() {
        _createNewActivity.postValue(true)
    }

}