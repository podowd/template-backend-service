package com.example.demo.utils

import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.utils.io.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
class HttpClientBlockchainTest {

    @Test
    fun `httpClientTest`() = runBlocking {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("https://ktor.io/")
        println(response.status)
        println(response.body<String>())
    }

    @Test
    fun `httpClientTest3`() = runBlocking {

        val httpResponse: HttpResponse = client.post("https://postman-echo.com/post") {
            url {
                parameter("qp1", "1");
                parameter("qp2", "2")
            }
            contentType(ContentType.Application.Json)
            setBody(Post(1, 1, "title", "body"))
        }
        println(httpResponse.status.isSuccess())
        val response: String = httpResponse.body()
        println(response)
    }

    @Test
    fun `mockHttpResponseTest`() = runBlocking {

        val postRequest = Post(1, 1, "title", "body")
        val httpClientMock = mockHttpClient(postRequest)
        val postResponse: Post = httpClientMock.get("http://127.0.0.1").body()
        assertEquals(postRequest, postResponse)
    }

    private fun mockHttpClient(postRequest: Post): HttpClient {
        val mockEngine = MockEngine { _ ->
            respond(
                content = ByteReadChannel(Gson().toJson(postRequest)),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val httpClientMock = HttpClient(mockEngine) {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }
        }
        return httpClientMock
    }

    companion object {
        private val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                gson {
                    setPrettyPrinting()
                }
            }
        }

        @JvmStatic
        @AfterAll
        internal fun afterAll() {
            client.close()
        }
    }

    data class Post(val userId: Int, val id: Int, val title: String, val body: String)
}