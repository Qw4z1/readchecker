package io.nyblom.readchecker.api

import com.apollographql.apollo3.ApolloClient
import io.nyblom.readchecker.BuildConfig

val apolloClient = ApolloClient.Builder()
    .serverUrl(BuildConfig.NHOST_SERVER_URL)
    .build()