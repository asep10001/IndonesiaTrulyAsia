package id.kotlin.indonesiatrulyasia.adpaters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.indonesiatrulyasia.R
import id.kotlin.indonesiatrulyasia.details.RegionsDetail
import id.kotlin.indonesiatrulyasia.models.data.Regions
import kotlinx.android.synthetic.main.fragment_regions.view.*

class RegionsAdapter(var provinsi: ArrayList<Regions>?) :
    RecyclerView.Adapter<RegionsAdapter.RegionsHolder>() {
    class RegionsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textIdRegions = itemView.textIdRegions
        val textNamaRegions = itemView.textNamaRegions
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RegionsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_regions, parent, false)

        return RegionsHolder(view)
    }

    override fun onBindViewHolder(holder: RegionsHolder, position: Int) {
        holder.textIdRegions.text = provinsi?.get(position)?.id.toString()
        holder.textNamaRegions.text = provinsi?.get(position)?.nama.toString()

        holder.itemView.setOnClickListener {

            val intent = Intent(holder.itemView.context, RegionsDetail::class.java)

//            //action klik
            intent.putExtra("id", provinsi?.get(position)?.id)
            intent.putExtra("nama", provinsi?.get(position)?.nama.toString())



            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return provinsi?.size ?: 0
    }
}

