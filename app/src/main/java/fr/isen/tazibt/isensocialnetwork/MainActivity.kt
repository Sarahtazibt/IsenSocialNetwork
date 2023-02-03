package fr.isen.tazibt.isensocialnetwork

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import fr.isen.tazibt.isensocialnetwork.databinding.ActivityCreationBinding
import fr.isen.tazibt.isensocialnetwork.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var postList: ArrayList<Post>
    private lateinit var mAdapter: PostAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /**initialized*/
        postList = ArrayList()
        mAdapter = PostAdapter(postList) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("post", it)
            startActivity(intent)
        }
        binding.recyclerPost.layoutManager = LinearLayoutManager(this)
        binding.recyclerPost.adapter = mAdapter
        /**getData firebase*/
        getPosts()

    }

    /**ok now create new activity*/


    private fun getPosts() {

        mDataBase = FirebaseDatabase.getInstance().getReference("posts")
        mDataBase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val posts = snapshot.children.map {
                    it.getValue<Post>()
                }
                mAdapter.refreshList(posts as ArrayList<Post>)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(
                    this@MainActivity,
                    error.message, Toast.LENGTH_SHORT
                ).show()
            }

        })


    }
}
