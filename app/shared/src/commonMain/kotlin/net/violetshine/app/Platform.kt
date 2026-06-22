package net.violetshine.app

interface Platform {
  val name: String
}

expect fun getPlatform(): Platform
