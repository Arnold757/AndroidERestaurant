package fr.isen.dedji.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.dedji.androiderestaurant.model.Items

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getSerializableExtra("dishes") as Items
    }
}