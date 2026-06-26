package net.violetshine.app

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletResponse

class CacheControlFilter: Filter {
  override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
    val httpResponse = response as HttpServletResponse
    
    httpResponse.setHeader("Cache-Control", "public, max-age=7200, stale-if-error=60")
    
    chain!!.doFilter(request, response)
  }
}
