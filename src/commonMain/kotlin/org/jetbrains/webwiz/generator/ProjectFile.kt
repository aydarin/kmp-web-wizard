package org.jetbrains.webwiz.generator

interface ProjectFile {
    val path: String
    val content: String
}

interface ProjectFileFromResources : ProjectFile {
    override val content: String get() = "/* will be generated from resources */"
    val resourcePath: String
}

interface ProjectDirectoryFromResources : ProjectFileFromResources
