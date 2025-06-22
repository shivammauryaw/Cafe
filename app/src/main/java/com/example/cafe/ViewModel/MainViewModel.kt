package com.example.cafe.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cafe.Domain.BannerModel
import com.example.cafe.Domain.CategoryModel
import com.example.cafe.Domain.ItemsModel
import com.example.cafe.Repository.MainRepository

class MainViewModel:ViewModel() {
    private val repository=MainRepository()

    fun loadBanner():LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }

    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }

    fun loadPopular():LiveData<MutableList<ItemsModel>>{
        return repository.loadPopular()
    }

    fun loadItems(categoryId:String):LiveData<MutableList<ItemsModel>>{
        return repository.loadItemCategory(categoryId)
    }
}