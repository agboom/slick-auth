package aj.scalatra.auth.controllers

import aj.scalatra.auth.AuthComponent
import org.scalatra.ScalatraServlet

trait SecuredComponent { this: AuthComponent =>

  /**
   * Trait that ensurs that before every request, the user is authenticated.
   * And otherwise calls scentry's authenticate method
   */
  trait Secured extends AuthSupport { this: ScalatraServlet =>

    before() {
      if(!isAuthenticated)
        doOnUnauthenticated()
    }
  }
}
