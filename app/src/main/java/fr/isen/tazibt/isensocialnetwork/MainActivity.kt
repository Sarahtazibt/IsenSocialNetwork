package fr.isen.tazibt.isensocialnetwork

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.mediation.Adapter
import fr.isen.tazibt.isensocialnetwork.PostAdapter
import fr.isen.tazibt.isensocialnetwork.Post
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mDataBase: DatabaseReference
    private lateinit var postList:ArrayList<Post>
    private lateinit var mAdapter:PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**initialized*/
        postList = ArrayList()
        mAdapter = PostAdapter(this,postList)
        recyclerPosts.layoutManager = LinearLayoutManager(this)
        recyclerPosts.setHasFixedSize(true)
        // recyclerPosts.adapter = mAdapter
        /**getData firebase*/
        getPosts()

    }
    /**ok now create new activity*/


    private fun getPosts() {

        mDataBase = FirebaseDatabase.getInstance().getReference("Posts")
        mDataBase.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (postSnapshot in snapshot.children){
                        val post = postSnapshot.getValue(Post::class.java)
                        postList.add(post!!)
                    }
                    recyclerPosts.adapter = mAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,
                    error.message, Toast.LENGTH_SHORT).show()
            }

        })


    }




}