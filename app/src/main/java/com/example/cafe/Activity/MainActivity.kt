package com.example.cafe.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cafe.Adapter.CategoryAdapter
import com.example.cafe.Adapter.PopularAdapter
import com.example.cafe.ViewModel.MainViewModel
import com.example.cafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel=MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
        initcategory()
        initPopular()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility= View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility=View.GONE
        }
        viewModel.loadBanner()
    }

    private fun initcategory(){
        binding.progressBarCategory.visibility=View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.recyclerViewCategory.layoutManager=
                LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)

            binding.recyclerViewCategory.adapter=CategoryAdapter(it)
            binding.progressBarCategory.visibility=View.GONE
        }
        viewModel.loadCategory()
    }

    private fun initPopular(){
        binding.progressBarPopular.visibility=View.VISIBLE
        viewModel.loadPopular().observeForever {
            binding.recyclerViewPopular.layoutManager= GridLayoutManager(this,2)
            binding.recyclerViewPopular.adapter=PopularAdapter(it)
            binding.progressBarPopular.visibility=View.GONE
        }
        viewModel.loadPopular()
    }
}