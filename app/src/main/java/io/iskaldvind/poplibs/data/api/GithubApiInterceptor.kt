package io.iskaldvind.poplibs.data.api

import io.iskaldvind.poplibs.BuildConfig
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

object GithubApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic(BuildConfig.GITHUB_USER_NAME, BuildConfig.GITHUB_USER_PASSWORD))
                .build()
        )
}