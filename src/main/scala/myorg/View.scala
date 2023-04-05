package myorg

import tyrian.Html
import tyrian.Html.*
import tyrian.Tyrian

def render(model: SpacesModel): Html[Msg] =
  div(
    renderNavbar,
    renderHero,
    div(`class` := "container bg-red mt-4")(
      div(`class` := "row row-cols-1 row-cols-md-3 g-4")(
        model.spaces.map { space =>
          div(`class` := "col")(
            div(`class`   := "card h-100")(
              img(`class` := "card-static-top", src := "assets/images/logo.png"),
              div(`class` := "card-body")(
                p(`class` := "card-title")(space.title)
              ),
              ul(`class` := "list-group list-group-flush")(
                li(`class` := "list-group-item")(space.address)
              ),
              div(`class` := "card-body")(
                a(`class` := "card-link")("ver")
              )
            )
          )
        }
      )
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
    div(`class` := "container-fluid")(
      a(`class` := "navbar-brand", href := "/")(text("Rocking Spaces")),
      button(
        attributes(
          "class"          -> "navbar-toggler",
          "type"           -> "button",
          "data-bs-toggle" -> "collapse",
          "data-bs-target" -> "#navId",
          "aria-expanded"  -> "false",
          "aria-label"     -> "Toggle navigation",
          "aria-controls"  -> "navId"
        )
      )(
        span(`class` := "navbar-toggler-icon")()
      ),
      div(`class` := "collapse navbar-collapse", id := "navId")(
        ul(
          `class` := "navbar-nav"
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
