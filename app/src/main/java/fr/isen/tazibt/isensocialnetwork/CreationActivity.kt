package fr.isen.tazibt.isensocialnetwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.tazibt.isensocialnetwork.databinding.ActivityCreationBinding

class CreationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_creation)

        val intent = Intent(this, Connexion_Activity::class.java)
        binding.Firstbutton.setOnClickListener {

            intent.putExtra("Category", "Entrées")
            startActivity(intent)
        }

        binding.Secondbutton.setOnClickListener {
            intent.putExtra("Category", "Plats")
            startActivity(intent)
        }
    }
}