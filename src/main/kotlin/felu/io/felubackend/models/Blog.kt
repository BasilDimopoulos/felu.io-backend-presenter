package felu.io.felubackend.models

import nonapi.io.github.classgraph.json.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Blog {
    @Id
    var id=""
    var name=""
    var email=""
    var password=""
}