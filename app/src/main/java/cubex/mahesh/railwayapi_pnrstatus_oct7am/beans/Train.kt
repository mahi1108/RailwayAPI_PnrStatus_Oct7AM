package cubex.mahesh.railwayapi_pnrstatus_oct7am.beans

import com.google.gson.annotations.SerializedName

data class Train(@SerializedName("number")
                 val number: String = "",
                 @SerializedName("name")
                 val name: String = "")