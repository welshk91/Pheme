package com.welshk.pheme.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.welshk.pheme.R
import com.welshk.pheme.model.Article

/**
 * File that provides DataBinding Adapters for Picasso
 * https://square.github.io/picasso/
 */

/**
 * https://stackoverflow.com/questions/66518908/load-image-by-picasso-in-recyclerview-by-databinding-kotlin
 */
@BindingAdapter("articleUrl")
fun loadArticleImage(view: ImageView, article: Article?) {
    if (article != null) {
        if (article.urlToImage.isNullOrBlank()) {
            Picasso.get()
                .load(R.drawable.markus_winkler_aid_xyrtlec_unsplash)
                .priority(Picasso.Priority.HIGH)
                .into(view)
        } else {
            Picasso.get()
                .load(article.urlToImage)
                .priority(Picasso.Priority.HIGH)
                .into(view)
        }
    }
}