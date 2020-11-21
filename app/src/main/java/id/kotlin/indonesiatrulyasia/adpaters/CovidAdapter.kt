package id.kotlin.indonesiatrulyasia.adpaters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.indonesiatrulyasia.R
import id.kotlin.indonesiatrulyasia.details.BatikDetail
import id.kotlin.indonesiatrulyasia.details.CovidDetail
import id.kotlin.indonesiatrulyasia.models.data.Covid
import kotlinx.android.synthetic.main.fragment_batik.view.*
import kotlinx.android.synthetic.main.fragment_covid.view.*

class CovidAdapter (var list_data: ArrayList<Covid>?) : RecyclerView.Adapter<CovidAdapter.CovidHolder>(){
    class CovidHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textCovidNamaProvinsi = itemView.textCovidNamaProvinsi
        val textCovidJumlahKejadian = itemView.textCovidJumlahKejadian
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidAdapter.CovidHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_covid,parent,false)

        return CovidAdapter.CovidHolder(view)
    }

    override fun onBindViewHolder(holder: CovidAdapter.CovidHolder, position: Int) {
        holder.textCovidNamaProvinsi.text = list_data?.get(position)?.key
        holder.textCovidJumlahKejadian.text = list_data?.get(position)?.jumlah_kasus.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, CovidDetail::class.java)

//            //action klik
            intent.putExtra("key", list_data?.get(position)?.key)
            intent.putExtra("jumlah_kasus", list_data?.get(position)?.jumlah_kasus.toString())
            intent.putExtra("jumlah_dirawat", list_data?.get(position)?.jumlah_dirawat.toString())
            intent.putExtra("jumlah_meninggal", list_data?.get(position)?.jumlah_meninggal.toString())
            intent.putExtra("jumlah_sembuh", list_data?.get(position)?.jumlah_sembuh.toString())


            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return list_data?.size ?: 0
    }
}