package ca.wihraiech.mytestapp.common

import android.annotation.SuppressLint
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey


@SuppressLint("CheckResult")
fun ImageView.loadUrl(url: String) {
    val requestOptions = RequestOptions()
    requestOptions.signature(ObjectKey(System.currentTimeMillis()))
    Glide.with(this).
        load(url)
        .centerCrop()
        .apply(requestOptions)
        .into(this)
}
