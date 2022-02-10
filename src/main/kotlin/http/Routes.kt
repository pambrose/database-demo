package org.athenian

import io.ktor.http.*
import io.ktor.http.ContentType.Text.CSS
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.img
import kotlinx.html.li
import kotlinx.html.link
import kotlinx.html.p
import kotlinx.html.title
import kotlinx.html.ul
import mu.KotlinLogging

const val greeting = "Hello world from ktor-example!"
val logger = KotlinLogging.logger {}

fun Application.routes() {

  routing {

    static("/static") {
      resources("static")
    }

    get("/") {
      call.respondText(greeting, contentType = ContentType.Text.Plain)
    }

    get("/myfile") {
      call.respondHtml {
        head {
          title { +"My HTML File" }
        }
        body {
          h1 { +"Big Title" }
          p { +"Some random words" }
          img { src = "/static/ktor_logo.svg"; alt = "ktor logo"; width = "200"; height = "200" }
        }
      }
    }

    get("/html") {
      val params = call.request.queryParameters
      call.respondHtml {
        head {
          link { rel = "stylesheet"; href = "/styles.css"; type = CSS.toString() }
        }
        body {
          h1 { +"Hello ${params["first"] ?: ""} ${params["last"] ?: ""} my list is:" }

          div(classes = "mylist") {
            ul {
              (1..10).forEach { n ->
                li { +"Item $n" }
              }
            }
          }
        }
      }
    }
  }
}