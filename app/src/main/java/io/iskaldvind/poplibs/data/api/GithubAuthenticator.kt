package io.iskaldvind.poplibs.data.api

import io.iskaldvind.poplibs.BuildConfig
import okhttp3.*


object GithubAuthenticator : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        return response.request
            .newBuilder()
            .header("Authorization", Credentials.basic(
                BuildConfig.GITHUB_USER_NAME,
                BuildConfig.GITHUB_USER_PASSWORD
            ))
            .build()
    }
}