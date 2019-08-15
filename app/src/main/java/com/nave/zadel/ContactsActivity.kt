package com.nave.zadel

import android.os.Bundle
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_contacts.*

class ContactsActivity : AppCompatActivity() {

    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        actionBar?.setDisplayHomeAsUpEnabled(true)

        var list = mutableListOf<ContactData>()

        for(i in 1..20){
            list.add(ContactData("Joana $i", "I'm ok and happy..."))
        }

        viewAdapter = ContactsAdapter(list)
        viewManager = LinearLayoutManager(this)
        contacts_design_list.adapter = viewAdapter
        contacts_design_list.layoutManager = viewManager

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}
