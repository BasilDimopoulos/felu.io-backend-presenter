package felu.io.felubackend.repositories

import felu.io.felubackend.models.Blog
import org.springframework.data.mongodb.repository.MongoRepository

interface BlogRepository: MongoRepository<Blog, String> {
}