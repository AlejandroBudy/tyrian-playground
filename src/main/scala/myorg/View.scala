package myorg

import tyrian.Html
import tyrian.Html.*
import tyrian.Html.`class`
import tyrian.Tyrian

def render(model: SpacesModel): Html[Msg] =
  div(`class` := "container")(
    div(`class` := "navbar")(
      h1(attribute("align", "center"))(text("Rocking Spaces"))
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
