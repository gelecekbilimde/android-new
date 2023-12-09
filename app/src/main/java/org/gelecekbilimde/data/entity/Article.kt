package org.gelecekbilimde.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import org.gelecekbilimde.data.local.Converters
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 *
 * @author ferhatozcelik
 * @since 2023-03-28
 */

@Parcelize
@Entity(tableName = "article_table")
data class Article(
    @PrimaryKey(autoGenerate = true)
    var articleId: Int? = null,
    val articleTitle: String?,
    val articleContent: String?,
    @TypeConverters(Converters::class)
    val articleCategory: MutableList<Categories>?,
    val articleImageUrl: String,
    val authorId: Int?,
    val authorName: String?,
    val authorUrl: String?,
    val isBookmark: Boolean?,
    val articleCreateAtDate: Date?
) : Parcelable