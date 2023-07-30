package com.marijarin.pictures.dto

import com.marijarin.pictures.R

data class Img (
    val id: Int,
    val image: String
)
val testImg = Img(0,"R.drawable.sarah_mahmuda_qsejkuxta4c_unsplash")

data class ImgRes(
    val id: Int,
    val image: Int,
    val author: String,
    val year: Int
)
val testImgRes = ImgRes(0, R.drawable.sarah_mahmuda_qsejkuxta4c_unsplash, "Sarah Mahmuda", 2020)
val picsResList: List<ImgRes> = listOf(
    ImgRes(1, R.drawable.dave_fuuxj1y20qm_unsplash, "Dave", 2023),
    ImgRes(2, R.drawable.henrik_l_bziga9jyapa_unsplash, "Henrik L.", 2022),
    ImgRes(3, R.drawable.vasilina_sirotina_ehc_pli3wc8_unsplash, "Vasilina Sirotina", 2023),
    ImgRes(4, R.drawable.joshua_kettle_n0bkebtvn_i_unsplash, "Joshua Kettle", 2023),

    )