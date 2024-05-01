package com.adilegungor.imagegenerator.data

import android.content.ContentResolver
import android.graphics.drawable.BitmapDrawable
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast

class ImageSaver {

    fun guardarFondo(imagen: ImageView, contentResolver: ContentResolver, ) {
        val bitmap = (imagen.drawable as BitmapDrawable).bitmap

        val imagenUri = MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap,
            "generated_background.jpg",
            "Carlos Montalvo (Dalle) tarafından oluşturuldu."
        )
    }

}