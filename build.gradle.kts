import org.gradle.api.tasks.Delete
import org.gradle.external.javadoc.CoreJavadocOptions

buildscript {
    val kotlinVersion = "1.4.20"

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }
}

allprojects {
    tasks.withType<Javadoc> {
        (options as CoreJavadocOptions).addStringOption("Xdoclint:none", "-quiet")
        options.encoding = "UTF-8"
    }

    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    delete(File("buildSrc/build"))
}
