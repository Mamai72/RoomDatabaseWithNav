package com.ib.roomdatabasewithnav.data

import androidx.lifecycle.LiveData

class PersonRepository(private val personDao: PersonDao) {
    val readAllData: LiveData<List<Person>> = personDao.readAllData()
    suspend fun addPerson(person: Person){
        personDao.addPerson(person)
    }
}