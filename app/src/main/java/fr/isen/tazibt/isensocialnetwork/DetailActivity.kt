package fr.isen.tazibt.isensocialnetwork

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import fr.isen.tazibt.isensocialnetwork.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val items = intent.getSerializableExtra("posts") as Post
    }
}