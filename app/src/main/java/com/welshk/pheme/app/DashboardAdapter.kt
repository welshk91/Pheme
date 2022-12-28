package com.welshk.pheme.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.welshk.pheme.R
import com.welshk.pheme.model.Article

class DashboardAdapter(
    private val context: Context,
    private val articles: ArrayList<Article>?,
    private val listener: (Article) -> Unit = {}
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ViewHolder(context, view)
    }

    override fun getItemCount(): Int {
        return articles?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        articles?.get(position)?.let {
            holder.title.text = it.title
            holder.author.text = it.author

            Picasso.get()
                .load(it.urlToImage)
                .into(holder.image)

            holder.setOnItemClickedListener(it, listener)
        }
    }

    class ViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)
        var author: TextView = view.findViewById(R.id.author)
        var image: AppCompatImageView = view.findViewById(R.id.image)

        internal fun setOnItemClickedListener(
            article: Article,
            listener: (Article) -> Unit
        ) {
            title.setOnClickListener {
                listener(article)
            }
        }
    }
}