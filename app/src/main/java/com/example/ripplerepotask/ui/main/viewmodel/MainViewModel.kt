package com.example.ripplerepotask.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ripplerepotask.data.api.ApiService
import com.example.ripplerepotask.data.model.RepoResponse
import com.example.ripplerepotask.data.model.Repository
import com.example.ripplerepotask.data.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class  MainViewModel constructor(private val mainRepository: MainRepository): ViewModel() {

    val listRepo = MutableLiveData<ArrayList<Repository>>()

    fun setSearchRepos(query: String){
//        apiService
//            .getDataFromApi(query)
        mainRepository
            .getRepos(query)
            .enqueue(object : Callback<RepoResponse>{
                override fun onResponse(
                    call: Call<RepoResponse>,
                    response: Response<RepoResponse>
                ) {
                    if(response.isSuccessful){
                        listRepo.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }

    fun getSearchRepos(): LiveData<ArrayList<Repository>>{
        return listRepo;
    }
}