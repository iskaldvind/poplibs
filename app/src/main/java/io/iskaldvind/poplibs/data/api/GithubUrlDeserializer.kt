package io.iskaldvind.poplibs.data.api

/*
import com.google.gson.*
import io.iskaldvind.poplibs.data.user.DEFAULT_GITHUB_URL
import io.iskaldvind.poplibs.data.user.GitHubUrl
import java.lang.reflect.Type

class GithubUrlDeserializer : JsonDeserializer<GitHubUrl> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): GitHubUrl {
        return json?.let {
            GitHubUrl(it.asString)
        } ?: DEFAULT_GITHUB_URL
    }
}

class GithubUrlSerializer : JsonSerializer<GitHubUrl> {
    override fun serialize(
        src: GitHubUrl?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return {} as JsonElement
    }
}
*/