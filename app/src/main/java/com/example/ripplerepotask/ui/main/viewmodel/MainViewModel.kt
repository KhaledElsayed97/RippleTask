package com.example.ripplerepotask.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.apiservice.ApiService
import com.example.data.repo.RemoteRepoImpl
import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import com.example.domain.usecases.GetReposUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class  MainViewModel @Inject constructor(val apiInstance: ApiService): ViewModel() {

    val listRepo = MutableLiveData<ArrayList<Repository>>()

    fun setSearchRepos(query: String){
//        apiService
//            .getDataFromApi(query)
        apiInstance
            .getDataFromApi(query)
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