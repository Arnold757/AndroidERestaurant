package fr.isen.dedji.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.dedji.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this, CategoryActivity::class.java)
        binding.startMenu.setOnClickListener{

           // Snackbar.make(it, "affichage", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText(this,"Chargement des entrées,Toast.LENGTH_SHORT)

            intent.putExtra( "Category", "Entrées")
            startActivity(intent)
        }

        binding.dishMenu.setOnClickListener{

            // Snackbar.make(it, "affichage", Snackbar.LENGTH_SHORT).show()
           //Toast.makeText(this,"Chargement des entrées,Toast.LENGTH_SHORT)

            intent.putExtra("Category", "Plats")
            startActivity(intent)}

        binding.desertMenu.setOnClickListener{

            // Snackbar.make(it, "affichage", Snackbar.LENGTH_SHORT).show()
            //Toast.makeText(this,"Chargement des entrées,Toast.LENGTH_SHORT)

            intent.putExtra("Category", "Desserts")
            startActivity(intent)}



    }
}