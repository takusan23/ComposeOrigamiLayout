# ComposeOrigamiLayout
FlexLayoutのように折り返して表示するレイアウト（Jetpack Compose）を追加するライブラリです。

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
    implementation 'com.github.takusan23:ComposeOrigamiLayout:1.0.1' // バージョンは最新のを使って
}
```
