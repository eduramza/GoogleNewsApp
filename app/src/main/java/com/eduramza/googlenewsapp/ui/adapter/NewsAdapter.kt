package com.eduramza.googlenewsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.eduramza.googlenewsapp.R
import com.eduramza.googlenewsapp.data.model.NewsResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(private val listNews: MutableList<NewsResponse.Article>,
                  private val listener: NewsListener)
    : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_news))
    }

    override fun getItemCount() = listNews.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listNews[position])
    }

    fun updateList(list: MutableList<NewsResponse.Article>){
        this.listNews.clear()
        this.listNews.addAll(list)
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(article: NewsResponse.Article) {
            itemView.tv_item_news_title.text = article.title
            itemView.tv_item_news_description.text = article.description
            Picasso.get()
                .load(article.urlToImage)
                .fit().centerCrop()
                .into(itemView.im_item_news)

            itemView.card_news.setOnClickListener {
                listener.onItemCLick(article)
            }
        }

    }

    interface NewsListener{
        fun onItemCLick(item: NewsResponse.Article)
    }

}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}