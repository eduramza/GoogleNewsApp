package com.eduramza.googlenewsapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.eduramza.googlenewsapp.R
import com.eduramza.googlenewsapp.data.model.NewsResponse
import com.eduramza.googlenewsapp.ui.adapter.NewsAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), NewsAdapter.NewsListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupAdapter()
        setupObservers()
    }

    private fun setupAdapter(){
        adapter = NewsAdapter(mutableListOf(), this)
        rv_news.layoutManager = LinearLayoutManager(context)
        rv_news.adapter = adapter
    }

    private fun setupObservers(){
        viewModel.listHeadNews("br")
        viewModel.status.observe(viewLifecycleOwner, Observer {
            when(it){
                MyStatus.LOADING -> showLoading()
                MyStatus.DONE -> hideLoading()
                MyStatus.ERROR -> showError()
            }
        })
        viewModel.getNews().observe(viewLifecycleOwner, Observer {
            adapter.updateList(it as MutableList<NewsResponse.Article>)
        })
    }

    private fun showError() {
        Log.d("MainFragment", "Deu erro aqui")
    }

    private fun hideLoading() {
        progress.visibility = GONE
        rv_news.visibility = VISIBLE
    }

    private fun showLoading() {
        progress.visibility = VISIBLE
        rv_news.visibility = GONE
    }

    override fun onItemCLick(item: NewsResponse.Article) {
        //Do nothing yet
    }

}