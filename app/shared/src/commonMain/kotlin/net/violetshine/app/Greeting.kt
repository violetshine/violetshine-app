package net.violetshine.app

class Greeting {
  private val platform = getPlatform()

  fun greet(): String {
    return sayHello(platform.name)
  }
}
