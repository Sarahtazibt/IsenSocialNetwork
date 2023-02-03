package fr.isen.tazibt.isensocialnetwork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.tazibt.isensocialnetwork.databinding.ActivityPostAdapterBinding

class PostAdapter(
    var postList:ArrayList<Post>, var onClickListener: (Post) -> Unit
):RecyclerView.Adapter<PostAdapter.PostViewHolder>()
{
    class PostViewHolder(view: View): RecyclerView.ViewHolder(view){
        val postImg = view.findViewById<ImageView>(R.id.postImg)
        val postBrand = view.findViewById<TextView>(R.id.postBrand)
        val postColor = view.findViewById<TextView>(R.id.postColor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_post_adapter, parent, false)
        return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.postBrand.text = post.carBrand
        holder.postColor.text = post.carColor

        val firstImage = post.carImg ?: ""
        if (firstImage.isNotEmpty()){
            Picasso.get().load(firstImage).into(holder.postImg)
        }

    }

    override fun getItemCount(): Int {
        return  postList.size
    }

    fun refreshList(newPosts: ArrayList<Post>) {
        postList = newPosts
        notifyDataSetChanged()
    }

}