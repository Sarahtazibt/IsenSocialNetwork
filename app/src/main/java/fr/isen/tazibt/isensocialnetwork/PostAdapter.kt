package fr.isen.tazibt.isensocialnetwork

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import fr.isen.tazibt.isensocialnetwork.databinding.ActivityPostAdapterBinding

class PostAdapter(
    var postList:ArrayList<Post>, var onClickListener: (Post) -> Unit
):RecyclerView.Adapter<PostAdapter.PostViewHolder>()
{
    inner class PostViewHolder(var v:ActivityPostAdapterBinding): RecyclerView.ViewHolder(v.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflter = LayoutInflater.from(parent.context)
        val v = DataBindingUtil.inflate<ActivityPostAdapterBinding>(
            inflter, R.layout.activity_post_adapter,parent,
            false)
        return PostViewHolder(v)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        holder.v.isPosts = post
        holder.v.root.setOnClickListener {
            onClickListener(post)
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