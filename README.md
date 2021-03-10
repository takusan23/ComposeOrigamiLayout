# ComposeOrigamiLayout
FlexLayoutのように折り返して表示するレイアウト（Jetpack Compose）を追加するライブラリです。

[![](https://jitpack.io/v/takusan23/ComposeOrigamiLayout.svg)](https://jitpack.io/#takusan23/ComposeOrigamiLayout)


<p align="center">
    <img src="https://imgur.com/PhdqoDH.png" width="200">
<p>

## サンプル
`sample`を見てください。

# 導入方法
JitPackから導入可能です。  

## allprojectsがある場合は

appフォルダじゃない方の`build.gradle`を開いて足します。  

```gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' } // これ
    }
}
```

## allprojectsがない（Canary版Android Studioはこっち）
`settings.gradle`を開いて足します。

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven { url 'https://jitpack.io' } // これ
    }
}
```

できたら、`app`フォルダ内の`build.gradle`を開いて足します。

```gradle
dependencies {
    implementation 'com.github.takusan23:ComposeOrigamiLayout:1.0.2' // バージョンは最新のを使って
}
```

# 使い方
置きます。以上

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeOrigamiLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    // これ
                    OrigamiLayout {
                        arrayListOf("カツドンチャンネル", "syamu_mad", "aiueo700", "syamu_MAD", "オフ会0人", "シャム本編リンク", "浜崎順平", "大物youtuberシリーズ", "なちゅらる9", "シャム総集編リンク")
                            .forEach { text ->
                                Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp)) {
                                    Text(text = text)
                                }
                            }
                    }
                }
            }
        }
    }
}
```

## 小さい順に並べる

引数の`isAcceptSort`を`true`にすることで小さい順に並びます。

```kotlin
OrigamiLayout(isAcceptSort = true) {
    arrayListOf("カツドンチャンネル", "syamu_mad", "aiueo700", "syamu_MAD", "オフ会0人", "シャム本編リンク", "浜崎順平", "大物youtuberシリーズ", "なちゅらる9", "シャム総集編リンク")
        .forEach { text ->
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(10.dp)) {
                Text(text = text)
            }
        }
}
```

# License

```
Copyright 2021 takusan_23

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```