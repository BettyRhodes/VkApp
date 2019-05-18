package com.example.vkapi.data.repository

import com.example.vkapi.domain.repository.PostRepository
import com.example.vkapi.presentation.models.BaseItem
import com.example.vkapi.presentation.models.PostMessage
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(): PostRepository{

    override fun getAll(): List<BaseItem> {
       return listOf(
            PostMessage(
                1,
                "Юрий Пожидаев",
                "Только сообщение",
                "",
                "",
                "",
                "",
                "14 мая 2019",
                10
            ), PostMessage(
                4,
                "Юрий Пожидаев",
                "Классная песня",
                "",
                "",
                "Murder On My Mind",
                "YNW Melly",
                "13 мая 2019",
                17
            )
            , PostMessage(
                2,
                "Юрий Пожидаев",
                "Пост с картинкой",
                "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                "",
                "",
                "",
                "12 мая 2019",
                23
            ), PostMessage(
                4, "Юрий Пожидаев",
                "Пост с видео",
                "",
                "Video",
                "",
                "",
                "11 мая 2019",
                32
            ), PostMessage(
                5, "Юрий Пожидаев",
                "Полный пост",
                "https://avatars.mds.yandex.net/get-pdb/199965/10d413ef-60a6-4d84-b4e8-75cf6e7a86d9/s1200",
                "Video",
                "Murder On My Mind",
                "YNW Melly",
                "5 мая 2019",
                21
            )
        )
    }

    override fun getPost(id: Int): BaseItem {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}