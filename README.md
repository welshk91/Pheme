<h1 align="center">Pheme</h1>
<h4 align="center">Simple News App</h4>

<p align="center">A news app that fetches articles

## Description
An educational, open app that digest the [News API](https://newsapi.org/). 

Written in Kotlin, this app uses the standard pillars of Android development: [Retrofit](https://square.github.io/retrofit/) for networking, [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) for Dependency Injection, [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [ViewModels](https://developer.android.com/topic/libraries/architecture/viewmodel), and [Databinding](https://developer.android.com/topic/libraries/data-binding) in an [MVVM](https://www.journaldev.com/20292/android-mvvm-design-pattern) pattern.

## What's "Pheme"?
[Pheme](https://en.wikipedia.org/wiki/Pheme) is a Greek goddess often described as "she who initiates and furthers communication".

## Disclaimer
This app is my open playground for discovering and experimenting with the Android world. 

It is _not_ intended to be a commercial product or even a consumer one. It will be lacking common features you'd expect in a news app.

## Sources
* [News API](https://newsapi.org/)
* [Markus Winkler - Placeholder image](https://unsplash.com/@markuswinkler)

## Improvements
* Add ability to open Chrome tab with rest of content (the API only has a snippet of the article)
* Add animations/motions
* Screenshots

## FAQ
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
    
## License
	Copyright 2022 Kevin Welsh
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
