package com.example.androidunittest

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.androidunittest.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnClick.setOnClickListener {
                val path = "${cacheDir.absolutePath}${File.separator}${System.currentTimeMillis()}.jpg"
                lifecycleScope.launch(Dispatchers.IO) {
                    saveViewAsImage(giantLinearLayout, path)
                    Log.d("MainActivity", "save path = ${path}")
                }
                Toast.makeText(this@MainActivity, "click me666", Toast.LENGTH_SHORT).show()
            }

            giantLinearLayout.setColorList(mutableListOf("#ffff00", "#00ffff"))
            giantCircleView.setColor("#ff0000")
            giantCircleView.setColorList(mutableListOf("#ff0000", "#00ffff"))
        }
    }


    suspend fun saveViewAsImage(view: View, filename: String?) {
        // 创建一个和View相同大小的空的Bitmap
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        // 使用上述创建的Bitmap，创建一个Canvas
        val canvas = Canvas(bitmap)
        // 将View绘制在Canvas上
        view.draw(canvas)
        // 将Bitmap写入到SD卡中
        val file = File(filename)
        try {
            val out = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out)
            out.flush()
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
