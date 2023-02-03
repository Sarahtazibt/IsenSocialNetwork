package fr.isen.tazibt.isensocialnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_post_adapter.*
import fr.isen.tazibt.isensocialnetwork.R
import fr.isen.tazibt.isensocialnetwork.uitel.getProgressDrawable
import fr.isen.tazibt.isensocialnetwork.uitel.loadImage
import kotlinx.android.synthetic.main.activity_call.*

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        val carImg=findViewById<ImageView>(R.id.postImg)
        val carYear=findViewById<TextView>(R.id.postYear)
        val carBrand=findViewById<TextView>(R.id.postBrand)
        val carColor=findViewById<TextView>(R.id.postColor)
        val carModel=findViewById<TextView>(R.id.postModel)
        val carHorsepower=findViewById<TextView>(R.id.postHorsepower)

        /**get Data*/
        val postIntent = intent
        val postImg = postIntent.getStringExtra("name")
        val postYear = postIntent.getStringExtra("info")
        val postBrand = postIntent.getStringExtra("img")
        val postColor = postIntent.getStringExtra("name")
        val postModel = postIntent.getStringExtra("info")
        val postHorsepower = postIntent.getStringExtra("img")

        /**call text and images*/
        carYear.text = postYear
        carBrand.text = postBrand
        carColor.text = postColor
        carModel.text = postModel
        carHorsepower.text = postHorsepower
        carImg.loadImage(postImg, getProgessDrawable(this))
    }
    /**ok now run it */
}