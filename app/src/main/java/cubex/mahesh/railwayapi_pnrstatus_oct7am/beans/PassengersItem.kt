package cubex.mahesh.railwayapi_pnrstatus_oct7am.beans

import com.google.gson.annotations.SerializedName

data class PassengersItem(@SerializedName("no")
                          val no: Int = 0,
                          @SerializedName("current_status")
                          val currentStatus: String = "",
                          @SerializedName("booking_status")
                          val bookingStatus: String = "")