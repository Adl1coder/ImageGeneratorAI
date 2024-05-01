package com.adilegungor.imagegenerator.data

import android.app.ProgressDialog
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ImageLoader (){

    fun cargarImagen(imageUrl: String, result: TextView, img1:ImageView, imgResized:ImageView, progressDialog: ProgressDialog) {

        GlobalScope.launch (Dispatchers.Main) {
            Picasso.get().load(imageUrl).resize(256,256).into(img1)
            result.setText("Yükleme sırasında başarılı")
            progressDialog.dismiss()

            Picasso.get().load(imageUrl).into(imgResized)
        }
    }

}