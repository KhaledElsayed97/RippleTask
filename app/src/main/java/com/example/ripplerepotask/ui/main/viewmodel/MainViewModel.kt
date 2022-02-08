package com.example.ripplerepotask.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.RepoResponse
import com.example.domain.entities.Repository
import com.example.domain.usecases.GetReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class  MainViewModel @Inject constructor(var getReposUseCase: GetReposUseCase): ViewModel() {

    val listRepo = MutableLiveData<ArrayList<Repository>>()

    fun setSearchRepos(query: String) {
        viewModelScope.launch {
            getReposUseCase
                .invoke(query)
                .enqueue(object : Callback<RepoResponse> {
                    override fun onResponse(
                        call: Call<RepoResponse>,
                        response: Response<RepoResponse>
                    ) {
                        if (response.isSuccessful) {
                            listRepo.postValue(response.body()?.items)
                        }
                    }

                    override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                        t.message?.let { Log.d("Failure", it) }
                    }

                })
        }
    }


    fun getSearchRepos(): LiveData<ArrayList<Repository>> {
        return listRepo;
    }
}
