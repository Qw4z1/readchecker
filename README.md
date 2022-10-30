# Companion App to Nyblom.io

This Android app was built to more easily be able to keep track of how many times my blog posts are read. Check out the [website repo](https://github.com/Qw4z1/nyblom-io) to get the full context.

It also gave me an excellent opportunity to try out Jetpack Compose and Material You theming.

## Tech stack

This app is built using [JetPack Compose](https://developer.android.com/jetpack/compose), [Apollo Kotlin](https://www.apollographql.com/docs/kotlin) and [Accompanist](https://github.com/google/accompanist) for Swipe Refresh.

The the current read count for each blog post is stored using [Nhost](https://nhost.io/).

## Getting Started


Step 1: Clone repository

```bash
git clone git@github.com:Qw4z1/readchecker.git
```

Step 2: Import project into Android Studio

Step 3: Add Nhost url

Get it from your current project

OR

1. Go to Nhost and [signup](https://app.nhost.io/signup)
2. Get your Nhost subdomain
3. Create a `config.properties` file with your Nhost Url:

```bash
echo "NHOST_SERVER_URL=\"https://[your subdomain here].nhost.run/v1/graphql\"" > config.properties
```

Step 4: Run the app!