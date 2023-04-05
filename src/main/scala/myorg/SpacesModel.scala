package myorg

final case class SpacesModel(spaces: List[SpacePreview])
object SpacesModel:
  def empty: SpacesModel = SpacesModel(
    List(
      SpacePreview(
        spaceId = "space-001",
        title = "Coworking Castellana",
        description = "Luminoso y centrico",
        address = "plaza castilla2"
      ),
      SpacePreview(
        spaceId = "space-002",
        title = "Coworking Cuzco",
        description = "Luminoso y centrico",
        address = "plaza cuzco"
      )
    )
  )

final case class SpacePreview(
    spaceId: String,
    title: String,
    description: String,
    address: String
)
