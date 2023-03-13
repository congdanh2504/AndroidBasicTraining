package com.example.room

import androidx.room.*

@Dao
abstract class UserDao {
    @Query("SELECT * FROM user")
    abstract fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    abstract fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    abstract fun findByName(first: String, last: String): User

    @Insert
    abstract fun insertAll(vararg users: User)

    @Delete
    abstract fun delete(user: User)

    @Transaction
    open fun insertAndDeleteInTransaction(newUser: User, oldUser: User) {
        insertAll(newUser)
        val user = findByName(oldUser.firstName!!, oldUser.lastName!!)
        delete(user)
    }
}