package id.kotlin.indonesiatrulyasia.adpaters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.indonesiatrulyasia.R
import id.kotlin.indonesiatrulyasia.details.CovidDetail
import id.kotlin.indonesiatrulyasia.details.MuseumDetail
import id.kotlin.indonesiatrulyasia.models.data.Covid
import id.kotlin.indonesiatrulyasia.models.data.Museum
import kotlinx.android.synthetic.main.fragment_batik.view.*
import kotlinx.android.synthetic.main.fragment_museum.view.*

class MuseumAdapter  (private var list_data: MutableList<Museum>?) : RecyclerView.Adapter<MuseumAdapter.MuseumHolder>() {
    class MuseumHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textNamaMuseum = itemView.textNamaMuseum
        val textLokasiMuseum = itemView.textLokasiMuseum
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumAdapter.MuseumHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_museum,parent,false)

        return MuseumAdapter.MuseumHolder(view)
    }

    override fun onBindViewHolder(holder: MuseumAdapter.MuseumHolder, position: Int) {
        holder.textNamaMuseum.text = list_data?.get(position)?.nama
        holder.textLokasiMuseum.text = list_data?.get(position)?.kabupaten_kota

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MuseumDetail::class.java)

//            //action klik

            intent.putExtra( "museum_id" ,list_data?.get(position)?.museum_id)
            intent.putExtra( "kode_pengelolaan" ,list_data?.get(position)?.kode_pengelolaan)
            intent.putExtra( "nama" ,list_data?.get(position)?.nama)
            intent.putExtra("sdm" ,list_data?.get(position)?.sdm)
            intent.putExtra("alamat_jalan" ,list_data?.get(position)?.alamat_jalan)
            intent.putExtra("desa_kelurahan" ,list_data?.get(position)?.desa_kelurahan)
            intent.putExtra("kecamatan" ,list_data?.get(position)?.kecamatan)
            intent.putExtra("kabupaten_kota" ,list_data?.get(position)?.kabupaten_kota)
            intent.putExtra("propinsi" ,list_data?.get(position)?.propinsi)
            intent.putExtra("lintang" ,list_data?.get(position)?.lintang)
            intent.putExtra("bujur" ,list_data?.get(position)?.bujur)
            intent.putExtra("koleksi" ,list_data?.get(position)?.koleksi)
            intent.putExtra("sumber_dana" ,list_data?.get(position)?.sumber_dana)
            intent.putExtra("pengelola" ,list_data?.get(position)?.pengelola)
            intent.putExtra("tipe" ,list_data?.get(position)?.tipe)
            intent.putExtra("standar" ,list_data?.get(position)?.standar)
            intent.putExtra("tahun_berdiri" ,list_data?.get(position)?.tahun_berdiri)
            intent.putExtra("bangunan" ,list_data?.get(position)?.bangunan)
            intent.putExtra("luas_tanah" ,list_data?.get(position)?.luas_tanah)
            intent.putExtra("status_kepemilikan" ,list_data?.get(position)?.status_kepemilikan)


            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return list_data?.size ?: 0
    }

}