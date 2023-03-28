package myorg

import tyrian.Html
import tyrian.Html.*
import tyrian.Html.`class`
import tyrian.Tyrian

def render(model: SpacesModel): Html[Msg] =
  div(
    nav(`class` := "navbar navbar-expand-lg bg-primary")(
      div(`class` := "container-fluid")(
        a(`class` := "navbar-brand")("Rocking Spaces"),
        button(
          attributes(
            ("class", "navbar-toggler"),
            ("type", "button"),
            ("data-bs-toggle", "collapse"),
            ("data-bs-target", "#navbarNav"),
            ("aria-controls", "navbarNav"),
            ("aria-expanded", "false")
          )
        )(
          span(`class` := "navbar-toggler-icon")()
        ),
        div(id := "navbarNav", `class` := "collapse navbar-collapse")(
          ul(`class` := "navbar-nav me-auto mb-2 mb-lg-0")(
            li(`class` := "nav-item")(
              a(`class` := "nav-link")("spaces")
            ),
            li(`class` := "nav-item")(
              a(`class` := "nav-link")("rooms")
            )
          ),
          div(`class` := "d-flex")(
            ul(`class` := "navbar-nav me-auto mb-2 mb-lg-0")(
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
    ),
    div(
      model.spaces.map { space =>
        div(
          h3(space.title),
          p(space.address)
        )
      }
    )
  )
