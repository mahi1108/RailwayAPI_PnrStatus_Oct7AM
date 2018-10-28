package cubex.mahesh.railwayapi_pnrstatus_oct7am.beans

import com.google.gson.annotations.SerializedName

data class JourneyClass(@SerializedName("code")
                        val code: String = "",
                        @SerializedName("name")
                        val name: String = "")