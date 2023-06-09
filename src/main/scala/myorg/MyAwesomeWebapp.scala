package myorg

import cats.effect.IO
import tyrian.Html.*
import tyrian.*
import tyrian.cmds.Logger

import java.util.UUID
import scala.concurrent.duration.*
import scala.scalajs.js.annotation.*

@JSExportTopLevel("TyrianApp")
object MyAwesomeWebapp extends TyrianApp[Msg, Model]:

  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    SpacesModel.empty -> Cmd.None

  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
    case Msg.AddSpace(space) => SpacesModel(model.spaces :+ space) -> Cmd.None
    case Msg.DeleteSpace(id) =>
      SpacesModel(model.spaces.filterNot(_.spaceId == id)) -> Cmd.None
    case Msg.Lookup(filter) => (model, Logger.info[IO](s"Filtering $filter"))

  def view(model: Model): Html[Msg] =
    render(model)

  def subscriptions(model: Model): Sub[IO, Msg] =
    Sub.make(
      "pulse",
      fs2.Stream
        .awakeEvery[IO](5.seconds)
        .map(t =>
          Msg.AddSpace(
            SpacePreview(
              t.toString(),
              "Random one",
              description = "Luminoso y centrico",
              "nowhere"
            )
          )
        )
    )

type Model = SpacesModel

enum Msg:
  case AddSpace(space: SpacePreview)
  case DeleteSpace(spaceId: String)
  case Lookup(filter: String)
