pluginManagement {
    repositories {
        maven(url="https://maven.aliyun.com/nexus/content/groups/public/")
        maven(url="https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven(url="https://maven.aliyun.com/repository/google")
        maven(url="https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://jitpack.io")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven(url="https://maven.aliyun.com/nexus/content/groups/public/")
        maven(url="https://maven.aliyun.com/nexus/content/repositories/jcenter")
        maven(url="https://maven.aliyun.com/repository/google")
        maven(url="https://maven.aliyun.com/repository/gradle-plugin")
        maven(url = "https://jitpack.io")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "AndroidTest"
include(":app")
 