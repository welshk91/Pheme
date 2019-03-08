Pheme
==========

An educational, open app that digest the [News API](https://newsapi.org/).

What's "Pheme"?
--------------
[Pheme](https://en.wikipedia.org/wiki/Pheme) is a Greek goddess often described as "she who initiates and furthers communication".

Disclaimer
----------
This app is my open playground for discovering and experimenting with the Android world. 

It is _not_ intended to be a commercial product or even a consumer one. It will be lacking common features you'd expect in a news app.

Sources
-------
* [News API](https://newsapi.org/)
* [News API - Documentation](https://newsapi.org/docs)
* [News API - Top Headlines](https://newsapi.org/docs/endpoints/top-headlines)

FAQ
---
* I cloned the repo, but I can't seem to get the app to compile/run?
    * If you are having trouble with the News API Key, you'll need to do the following
        * Create a `news_api.properties` file in the root directory (the directory with `local.properties`)
        * Add the News API Key to said file (You can get a key by creating an account [here](https://newsapi.org/))
            * Example: `apiKey="a6be2141d9a7bb47e9a0b56c24af8417a"`
* The article content seems to get cut off; What gives?
    * This is a limitation of the free Developer plan for access to the News API
        * `content` : `The unformatted content of the article, where available. This is truncated to 260 chars for Developer plan users.`
* The app no longer will retrieve new articles.
    * The free Developer plan also limits how many times you can ping the server (1000 requests/day).
* I can't search for articles older than a month. Why?
    * The free Developer plan limits how far back the app can search for articles. 

License
-------
There is currently no license I'm releasing this code under (subject to change). Feel free to use it in whatever way you see fit. 

Third-Party Libraries Used
--------------------------
* [Retrofit](https://square.github.io/retrofit/)
* [GSON](https://github.com/google/gson)
* [Timber](https://github.com/JakeWharton/timber)
