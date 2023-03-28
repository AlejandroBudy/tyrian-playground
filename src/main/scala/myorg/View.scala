package myorg

import tyrian.Html
import tyrian.Html.*
import tyrian.Html.`class`
import tyrian.Tyrian

def render(model: SpacesModel): Html[Msg] =
  div(`class` := "container-fluid")(
    nav(`class` := "navbar navbar-expand-lg bg-body-tertiary bg-primary")(
      div(`class` := "container-fluid")(
        span(`class` := "navbar-brand mb-0 h1")("Rocking Spaces")
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
