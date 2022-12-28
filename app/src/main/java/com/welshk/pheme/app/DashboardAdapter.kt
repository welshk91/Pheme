package com.welshk.pheme.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
        holder.title.text = articles!![position].title
        holder.setOnItemClickedListener(articles[position], listener)
    }

    class ViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView = view.findViewById(R.id.title)

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