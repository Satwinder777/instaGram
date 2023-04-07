package com.example.mymusic.dataClass

data class UnsplaceapiItem(
    val alt_description: String,
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>?,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val promoted_at: String,
    val sponsorship: Sponsorship,
    val updated_at: String,
    val user: User,
    val width: Int,
    var urls: Urls
)