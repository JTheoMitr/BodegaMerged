package android.example.bodegaversionone.data


import android.example.bodegaversionone.models.Product
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDAO {

    // a query function that will return our items by alphabetized titles
    @Query("SELECT * FROM item_table ORDER BY title ASC")
    fun getAlphabetizedItems(): Flow<List<Product>>

    // query function to insert a new item of data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: Product)

    // query function to delete table
    @Query("DELETE FROM item_table")
    suspend fun deleteAll()

    // a play/test function to try out grabbing items by category
    @Query("SELECT * FROM item_table ORDER BY category ASC")
    fun getAllByCategory() : Flow<List<Product>>

    // search function that returns a list of products that have the same title as the search
    @Query("SELECT * FROM item_table WHERE title MATCH :query")
    suspend fun searchTitle(query : String) : List<Product>

    // search function that returns a list of products that contain the query in the description
    @Query("SELECT * FROM item_table WHERE :query LIKE item_table.description")
    suspend fun searchDescriptions(query : String) : List<Product>

    // returns a list of products where category matches the query
    @Query("SELECT * FROM item_table WHERE category MATCH :query")
    suspend fun searchCategories(query : String) : List<Product>

    // returns the item with the selected PID
    @Query("SELECT * FROM item_table WHERE item_table.pid MATCH :query")
    suspend fun searchId(query: String) : List<Product>

    // return all prodcts by price
    @Query("SELECT * FROM item_table ORDER BY item_table.price ASC")
    suspend fun getAllByPrice() : List<Product>

}