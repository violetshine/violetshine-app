package net.violetshine.app.frontend.state

abstract class State<T> {
  protected val observers: MutableMap<String, (new: T) -> Unit> = mutableMapOf()

  abstract var value: T
    protected set

  protected fun setValue(new: T) {
    value = new
    observers.values.forEach { it(new) }
  }

  fun addObserver(name: String, onChange: (new: T) -> Unit) {
    if (observers[name] != null) {
      throw IllegalStateException("Duplicate observer name")
    }

    observers[name] = onChange
  }

  fun removeObserver(name: String) = observers.remove(name)
}
