package com.jboycode.demo.query

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.UUID

@Controller
class PostResolver {

    @QueryMapping
    fun getPosts(): List<PostDto> {
        return listOf(
            PostDto(
                id = UUID.randomUUID(),
                title = "test title",
                description = "some description"
            )
        )
    }

    @QueryMapping
    fun recentPosts(@Argument limit: Int, @Argument offset: Int): List<PostDto> {
        return listOf(
            PostDto(
                id = UUID.randomUUID(),
                title = "test title",
                description = "some description"
            ),
            PostDto(
                id = UUID.randomUUID(),
                title = "second test title",
                description = "second some description"
            )
        )
    }

    @MutationMapping
    fun  createPost(@Argument title: String, @Argument description: String?): PostDto {
        return PostDto(
            id = UUID.randomUUID(),
            title = title,
            description = description
        )
    }
}

data class PostDto(
    val id: UUID,
    val title: String,
    val description: String? = null
)