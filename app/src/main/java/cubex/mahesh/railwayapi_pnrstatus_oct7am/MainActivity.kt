package cubex.mahesh.railwayapi_pnrstatus_oct7am

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import cubex.mahesh.railwayapi_pnrstatus_oct7am.beans.PnrStatusBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {

            var r = Retrofit.Builder().
         addConverterFactory(GsonConverterFactory.create()).
         baseUrl("https://api.railwayapi.com/").
         build()
         var api:PnrStatusAPI = r.create(PnrStatusAPI::class.java)
         var call:Call<PnrStatusBean> = api.getPnrStatus(et1.text.toString())
          call.enqueue(object:Callback<PnrStatusBean>{
              override fun onResponse(call: Call<PnrStatusBean>, response: Response<PnrStatusBean>) {

                  var bean = response.body()
                  var temp_list = mutableListOf<String>()
                  temp_list.add("Name : ${bean!!.train.name}")
                  temp_list.add("Number : ${bean!!.train.number}")
                  temp_list.add("DOJ : ${bean!!.doj}")
                  temp_list.add("No Of Psgrs : ${bean!!.totalPassengers}")
                  temp_list.add("From Stat : ${bean!!.fromStation.name}")
                  temp_list.add("To Stat : ${bean!!.toStation.name}")
                  temp_list.add("Reser Upto : ${bean!!.reservationUpto.name}")
                  temp_list.add("Chart  Prep : ${bean!!.chartPrepared}")
                  temp_list.add("Bord  Poin : ${bean!!.boardingPoint.name}")
                  var psngrs = bean.passengers
                  for(passenger in psngrs!!)
                  {
                      temp_list.add("Res  Status : ${passenger.currentStatus}")

                  }

                var adapter = ArrayAdapter<String>(this@MainActivity,
                        android.R.layout.simple_list_item_single_choice,temp_list)
                  lview.adapter = adapter








              }
          override fun onFailure(call: Call<PnrStatusBean>, t: Throwable) {

              }
          })
        }

    }
}
