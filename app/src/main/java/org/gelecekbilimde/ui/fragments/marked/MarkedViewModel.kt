package org.gelecekbilimde.ui.fragments.marked

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.gelecekbilimde.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import org.gelecekbilimde.data.entity.MarkedArticle
import org.gelecekbilimde.data.entity.MarkedVideo
import org.gelecekbilimde.repository.VideoRepository
import javax.inject.Inject

/**
 *
 * @author ferhatozcelik
 * @since 2023-04-01
 */

@HiltViewModel
class MarkedViewModel @Inject constructor(private val articleRepository: ArticleRepository, private val videoRepository: VideoRepository, @ApplicationContext private val context: Context) : ViewModel() {

    var isProgressBarStatus: MutableLiveData<Boolean> = MutableLiveData()

    fun getMarkedArticle() = articleRepository.getMarkedArticle()

    fun getMarkedVideos() = videoRepository.getMarkedVideos()

    fun removeArticleBookmarks(markedArticle: MarkedArticle) = viewModelScope.launch {
        articleRepository.removeArticleBookmarks(markedArticle)
    }

    fun removeVideosBookmarks(markedVideo: MarkedVideo) = viewModelScope.launch {
        videoRepository.removeVideosBookmarks(markedVideo)
    }

}