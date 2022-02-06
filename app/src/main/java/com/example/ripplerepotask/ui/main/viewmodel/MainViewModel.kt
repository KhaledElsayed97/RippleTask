package com.example.ripplerepotask.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repo.RemoteRepoImpl
import com.example.domain.models.RepoResponse
import com.example.domain.models.Repository
import com.example.domain.usecases.GetReposUseCase
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class  MainViewModel constructor(val remoteRepoImpl: RemoteRepoImpl): ViewModel() {

    val listRepo = MutableLiveData<List<Repository>>()

    fun setSearchRepos(query: String){
        var listObservables:Observable<List<Repository>> = remoteRepoImpl
            .getRepos(query)

        listObservables.subscribe({value -> listRepo.postValue(value)},
            {error -> Log.d("error","error")},
            {Log.d("Completed","Completed")})

    }

    //                listRepo.postValue(it.items)

    fun getSearchRepos(): MutableLiveData<List<Repository>> {
        return listRepo;
    }
}