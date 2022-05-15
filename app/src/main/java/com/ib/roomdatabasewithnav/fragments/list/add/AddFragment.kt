package com.ib.roomdatabasewithnav.fragments.list.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ib.roomdatabasewithnav.R
import com.ib.roomdatabasewithnav.data.Person
import com.ib.roomdatabasewithnav.data.PersonViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {
    private lateinit var mPersonViewModel: PersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mPersonViewModel = ViewModelProvider(this).get(PersonViewModel::class.java)

        view.bAdd.setOnClickListener {
            addPersonToDatabase()
        }

        return view
    }

    private fun addPersonToDatabase() {
        val firstName = edFirstName.text.toString()
        val lastName = edLastName.text.toString()
        val age = edAge.text
        if (inputCheck(firstName, lastName, age)){
            //create user object
            val person = Person(0, firstName, lastName, Integer.parseInt(age.toString()))
            mPersonViewModel.addPerson(person)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Fill out all fields!!!", Toast.LENGTH_LONG).show()
        }

    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}