package ca.wihraiech.mytestapp.joke

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JokedetailsViewModel : ViewModel(){

    val typeLiveData = MutableLiveData<String>()
    val setupLiveData = MutableLiveData<String>()
    val punchlineLiveData = MutableLiveData<String>()

    fun updateUI(
        type: String,
        setup: String,
        punchline: String
    ){
        typeLiveData.value = type
        setupLiveData.value = setup
        punchlineLiveData.value = punchline
    }

}