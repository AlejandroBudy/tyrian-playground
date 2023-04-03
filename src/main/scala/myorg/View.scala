package myorg

import tyrian.Html.*
import tyrian.{Html, Tyrian}

def render(model: SpacesModel): Html[Msg] =
  div(
    renderNavbar,
    renderHero,
    div(
      model.spaces.map { space =>
        div(
          h3(space.title),
          p(space.address)
        )
      }
    )
  )

private def renderHero: Html[Msg] =
  div(`class` := "container-fluid bg-green")(
    div(`class` := "container text-center")(
      div(`class` := "row row-cols-1")(
        div(`class` := "col-md-6 offset-md-3 bg-blue")(
          div(`class` := "container-md pb-4 pt-5 bg-red")(
            h1(`class` := "display-5")(
              "Comparte tu espacio y encuentra el sitio perfecto"
            )
          ),
          div(`class` := "container-md pb-4 bg-yellow")(
            div(`class` := "input-group mb-3")(
              input(
                `class`     := "form-control",
                placeholder := "Buscar por cuidad, codigo postal,...",
                `type`      := "text",
                onInput(s => Msg.Lookup(s))
              )
            )
          )
        )
      )
    )
  )

private def renderNavbar: Html[Msg] =
  nav(`class` := "navbar navbar-expand-lg bg-primary")(
    div(`class` := "container")(
      a(`class` := "navbar-brand", href := "/")(text("Rocking Spaces")),
      button(
        attributes(
          "class"          -> "navbar-toggler",
          "type"           -> "button",
          "data-bs-toggle" -> "collapse",
          "data-bs-target" -> "#navbarNav",
          "aria-expanded"  -> "false",
          "aria-label"     -> "Toggle navigation",
          "aria-controls"  -> "navbarNav"
        )
      )(
        span(`class` := "navbar-toggler-icon")()
      ),
      div(id := "navbarNav", `class` := "collapse navbar-collapse")(
        ul(
          `class` := "navbar-nav ms-auto text-center"
        )(
          li(`class` := "nav-item")(
            a(`class` := "nav-link")("spaces")
          ),
          li(`class` := "nav-item")(
            a(`class` := "nav-link")("rooms")
          ),
          li(`class` := "nav-item")(
            a(`class` := "nav-link")("Login")
          ),
          li(`class` := "nav-item")(
            a(`class` := "nav-link")("Signup")
          )
        )
      )
    )
  )
