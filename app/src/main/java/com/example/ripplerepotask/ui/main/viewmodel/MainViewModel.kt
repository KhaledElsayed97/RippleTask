package com.example.ripplerepotask.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repo.RemoteRepoImpl
import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import com.example.domain.usecases.GetReposUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class  MainViewModel constructor(val remoteRepoImpl: RemoteRepoImpl): ViewModel() {

    val listRepo = MutableLiveData<ArrayList<Repository>>()

    fun setSearchRepos(query: String){
//        apiService
//            .getDataFromApi(query)
        remoteRepoImpl
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