package id.kotlin.indonesiatrulyasia.adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.indonesiatrulyasia.R
import id.kotlin.indonesiatrulyasia.models.data.MainSlide
import org.w3c.dom.Text

class MainSlideAdapter(private val mainSlide: List<MainSlide>) :
    RecyclerView.Adapter<MainSlideAdapter.MainSlideViewHolder>() {
    inner class MainSlideViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val title = view.findViewById<TextView>(R.id.textSlideDescription)
        private val imageIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)

        fun bind(mainSlide: MainSlide){
            title.text = mainSlide.title
            imageIcon.setImageResource(mainSlide.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainSlideViewHolder {
    return MainSlideViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.slide_item_container,
            parent,
            false
        )
    )
    }

    override fun onBindViewHolder(holder: MainSlideViewHolder, position: Int) {
       holder.bind(mainSlide[position])
    }

    override fun getItemCount(): Int {
        return mainSlide.size
    }
}