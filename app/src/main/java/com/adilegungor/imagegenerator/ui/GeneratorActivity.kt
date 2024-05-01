package com.adilegungor.imagegenerator.ui

import android.app.ProgressDialog
import android.app.WallpaperManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adilegungor.imagegenerator.data.ImageSaver
import com.adilegungor.imagegenerator.logic.LogicApi
import com.example.imagegenerator.databinding.ActivityMainBinding


class GeneratorActivity : AppCompatActivity() {

    private val api = LogicApi()
    private val saver = ImageSaver()

    private lateinit var binding: ActivityMainBinding
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Oluşturuluyor...")

        binding.btnGenerar.setOnClickListener {

            val entrada = binding.txtEntrada.text.toString()
            binding.textoResultado.text = "Sonuç"
            binding.textoResultado.setTextColor(0xFF000000.toInt())

            if (entrada.isEmpty()) {
                binding.textoResultado.text = "Lütfen metni girin"
                binding.textoResultado.setTextColor(0xFFFF0000.toInt())
            } else {
                progressDialog.show()
                api.callAPI(
                    entrada,
                    binding.textoResultado,
                    binding.imagenGenerada,
                    binding.imageViewReserva,progressDialog
                )
                binding.txtEntrada.setText("")
            }
        }

        binding.btnAplicar.setOnClickListener {

            val wallpaperManager = WallpaperManager.getInstance(applicationContext)
            val drawable = binding.imageViewReserva.drawable

            if (drawable is BitmapDrawable) {
                val bitmap = drawable.bitmap
                try {
                    wallpaperManager.setBitmap(bitmap)
                    Toast.makeText(
                        applicationContext,
                        "duvar kağıdı seti",
                        Toast.LENGTH_SHORT
                    ).show()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
        binding.btnDescargar.setOnClickListener {//guardar
            try{
                saver.guardarFondo(
                    binding.imageViewReserva,
                    contentResolver
                )
                Toast.makeText(
                    applicationContext,
                    "Arka plan başarıyla indirildi",
                    Toast.LENGTH_SHORT
                ).show()

            }catch (e:Exception){
                e.printStackTrace()
            }
        }

    }
}