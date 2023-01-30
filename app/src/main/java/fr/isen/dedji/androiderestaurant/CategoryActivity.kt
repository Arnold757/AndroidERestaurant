package fr.isen.dedji.androiderestaurant
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import fr.isen.dedji.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.dedji.androiderestaurant.model.DataResult
import fr.isen.dedji.androiderestaurant.model.Items
import org.json.JSONObject

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCategoryBinding
    private lateinit var category: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        category = intent.getStringExtra("category") ?:""

        //Creation de list et la recup sous forme de variable
        val dishes = resources.getStringArray(R.array.Plats).toList() as ArrayList<String>
        binding.categoryList.layoutManager = LinearLayoutManager( this)
        binding.categoryList.adapter = CategoryAdapter(arrayListOf()){
            val intent = Intent( this, DetailActivity:: class.java)
            startActivity(intent)
        }

        loadDishesFromAPI()
    }

    private fun loadDishesFromAPI(){
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject,{
            Log.w("CategoryActivity", "response : $it")
            handleAPIData(it.toString())
        }, {
            Log.w("CategoryActivity", "error : $it")

        })
        Volley.newRequestQueue(this).add(jsonRequest)
    }
    private fun handleAPIData(data:String){

        val dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategory = dishesResult.data.firstOrNull { it.nameFr == intent.getStringExtra("Category") }

        val adapter = binding.categoryList.adapter as CategoryAdapter
        adapter.refreshList(dishCategory?.items as  ArrayList<Items>)

    }

}