package cubex.mahesh.railwayapi_pnrstatus_oct7am

import cubex.mahesh.railwayapi_pnrstatus_oct7am.beans.PnrStatusBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PnrStatusAPI {
    @GET("v2/pnr-status/pnr/{pnrno}/apikey/3us4nq7cyl/")
    fun  getPnrStatus(@Path("pnrno") p1:String):Call<PnrStatusBean>
}