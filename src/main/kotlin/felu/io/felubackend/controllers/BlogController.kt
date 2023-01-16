package felu.io.felubackend.controllers

import felu.io.felubackend.models.Blog
import felu.io.felubackend.repositories.BlogRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/blogs")
class BlogController(private val blogRepository: BlogRepository) {
    @GetMapping("/")
    fun getUsers(): ResponseEntity<List<Blog>>{
        return ResponseEntity.ok(blogRepository.findAll())
    }

    @GetMapping("/{id}")
    fun getBlog(@PathVariable id: String): ResponseEntity<Blog>{
        return ResponseEntity.ok(blogRepository.findById(id).orElse(null))
    }

    @PostMapping("/")
    fun createBlog(@RequestBody blog: Blog) : ResponseEntity<Blog>{
        return ResponseEntity.ok(blogRepository.save(blog))
    }

    @PutMapping("/{id}")
    fun updateBlog(@PathVariable id: String, @RequestBody blog: Blog): ResponseEntity<Blog>{
        var oldBlog = this.blogRepository.findById(id).orElse(null)
        oldBlog.name = blog.name
        oldBlog.email = blog.email
        oldBlog.password = blog.password
        return ResponseEntity.ok(this.blogRepository.save(blog))
    }

    @DeleteMapping("/{id}")
    fun deleteBlog(@PathVariable id: String): ResponseEntity<String>{
        this.blogRepository.deleteById(id)
        return ResponseEntity.ok(id)
    }
}