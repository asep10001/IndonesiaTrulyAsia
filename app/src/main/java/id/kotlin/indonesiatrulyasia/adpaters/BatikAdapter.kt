package id.kotlin.indonesiatrulyasia.adpaters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.kotlin.indonesiatrulyasia.R
import id.kotlin.indonesiatrulyasia.details.BatikDetail
import id.kotlin.indonesiatrulyasia.models.data.Batik
import kotlinx.android.synthetic.main.fragment_batik.view.*

class BatikAdapter (var hasil: ArrayList<Batik>?) : RecyclerView.Adapter<BatikAdapter.BatikHolder>() {
    class BatikHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBatik = itemView.imageBatik
        val textNamaBatik = itemView.textNamaBatik

//        coba

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_batik,parent,false)

        return BatikHolder(view)
    }

    override fun getItemCount(): Int {
        return hasil?.size ?: 0
    }

    override fun onBindViewHolder(holder: BatikHolder, position: Int) {
        holder.textNamaBatik.text = hasil?.get(position)?.nama_batik
        Glide.with(holder.itemView.context).load(hasil?.get(position)?.link_batik).into(holder.imgBatik)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, BatikDetail::class.java)

//            //action klik
            intent.putExtra("nama_batik", hasil?.get(position)?.nama_batik)
            intent.putExtra("daerah_batik", hasil?.get(position)?.daerah_batik)
            intent.putExtra("makna_batik", hasil?.get(position)?.makna_batik)
            intent.putExtra("harga_rendah", hasil?.get(position)?.harga_rendah.toString())
            intent.putExtra("harga_tinggi", hasil?.get(position)?.harga_tinggi.toString())
            intent.putExtra("link_batik", hasil?.get(position)?.link_batik)


            holder.itemView.context.startActivity(intent)

        }
    }
}