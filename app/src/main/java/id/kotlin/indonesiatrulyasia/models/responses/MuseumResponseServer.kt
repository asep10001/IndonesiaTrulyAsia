package id.kotlin.indonesiatrulyasia.models.responses

import id.kotlin.indonesiatrulyasia.models.data.Museum

class MuseumResponseServer {
    var status_code : Int? = null
    var message : String? = null

    var data : ArrayList<Museum>? = null
}