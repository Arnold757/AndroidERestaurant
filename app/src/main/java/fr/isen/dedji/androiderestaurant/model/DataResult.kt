package fr.isen.dedji.androiderestaurant.model

import com.google.gson.annotations.SerializedName


data class DataResult (

  @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

)