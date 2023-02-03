package fr.isen.tazibt.isensocialnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import fr.isen.tazibt.isensocialnetwork.R
import fr.isen.tazibt.isensocialnetwork.databinding.ActivityPostAdapterBinding
import fr.isen.tazibt.isensocialnetwork.Post
import fr.isen.tazibt.isensocialnetwork.CallActivity

class PostAdapter(
    var c:Context,var postList:ArrayList<Post>
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
        val newList = postList[position]
        holder.v.isPosts = postList[position]
        holder.v.root.setOnClickListener {
            var userId:String? = null
            var carImg:String? = null
            var carYear:String? = null
            var carRetro:Boolean? = null
            var carBrand:String? = null
            var carColor:String? = null
            var carModel:String? = null
            var carHorsepower:String? = null

            /**set Data*/
            val mIntent = Intent(c,CallActivity::class.java)
            mIntent.putExtra("userId",userId)
            mIntent.putExtra("carImg",carImg)
            mIntent.putExtra("carYear",carYear)
            mIntent.putExtra("carRetro",carRetro)
            mIntent.putExtra("carBrand",carBrand)
            mIntent.putExtra("carColor",carColor)
            mIntent.putExtra("carModel",carModel)
            mIntent.putExtra("carHorsepower",carHorsepower)
            c.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return  postList.size
    }



}