package com.thahira.newsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.thahira.newsapp.data.model.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article_table")
    fun getArticles() : LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article) : Long

    @Delete
    suspend fun delete(article: Article)

    @Query("DELETE FROM article_table")
    suspend fun deleteAllArticles()
}