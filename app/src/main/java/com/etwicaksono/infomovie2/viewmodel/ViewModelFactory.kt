package com.etwicaksono.infomovie2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.etwicaksono.infomovie2.data.CatalogueRepository
import com.etwicaksono.infomovie2.di.Injection
import com.etwicaksono.infomovie2.ui.detail.DetailViewModel
import com.etwicaksono.infomovie2.ui.favoritelist.FavoriteListViewModel
import com.etwicaksono.infomovie2.ui.homelist.ListViewModel

class ViewModelFactory private constructor(private val mCatalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                ListViewModel(mCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mCatalogueRepository) as T
            }
             modelClass.isAssignableFrom(FavoriteListViewModel::class.java) -> {
                FavoriteListViewModel(mCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context):ViewModelFactory= instance?: synchronized(this){
            instance?: ViewModelFactory(Injection.provideRepository(context))
        }
    }
}