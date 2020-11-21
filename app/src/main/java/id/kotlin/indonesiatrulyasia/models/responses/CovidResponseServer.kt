package id.kotlin.indonesiatrulyasia.models.responses

import id.kotlin.indonesiatrulyasia.models.data.Covid

class CovidResponseServer {


    var last_date: String? = "2020-11-23";
    var current_data: Double? = 99.99524319673725;
    var missing_data: Double? = 0.004756803262750964;
    var tanpa_provinsi: Int? = 23;
    var list_data : ArrayList<Covid>? = null
}