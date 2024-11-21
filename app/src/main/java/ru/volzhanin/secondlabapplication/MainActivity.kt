package ru.volzhanin.secondlabapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val contacts = List(30) { index ->
            Contact(
                name = "Contact ${index + 1}",
                phoneNumber = "555-${(100..999).random()}-${(1000..9999).random()}",
                imageResId = R.drawable.ic_person
            )
        }

        val adapter = ContactAdapter(contacts) { contact ->
            Toast.makeText(this, "Clicked on: ${contact.name}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}
