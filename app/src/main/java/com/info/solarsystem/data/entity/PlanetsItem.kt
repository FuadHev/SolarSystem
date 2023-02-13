package com.info.solarsystem.data.entity

data class PlanetsItem (
    val basicDetails: List<BasicDetail>,
    val description: String,
    val id: Int,
    val imgSrc: List<ImgSrc>,
    val key: String,
    val name: String,
    val planetOrder: String,
    val source: String,
    val wikiLink: String
):java.io.Serializable