package chr

import chartreuse.{*, given}
import doodle.core.{Color, Point}

import scala.util.Random
import chartreuse.layout.{Line, Scatter}
import doodle.algebra
import doodle.algebra.{Path, Shape, Style}

object ChaRe02 extends App {

  // raw data
  val data = List.fill(10)(Point(Random.nextGaussian(), Random.nextGaussian()))

  // where to put the data
  val layout: Line[Point, Shape & Style & Path] = Line.default[Point]
    // theme override
    .forThemeable(theme =>
      theme
        .withStrokeColor(Themeable.Override(Some(Color.darkBlue)))
        .withStrokeWidth(Themeable.Override(3.0))
    )

  // data combined with layout
  val plot: Plot[algebra.Layout & Shape & Style & Path] =
    layout.toPlot(data)
      .withPlotTitle("Our Amazing Plot")
      .withXTitle("Awesomeness")
      .withYTitle("Marvellousness")

  // converted to picture
  val picture = plot.draw(640, 480)

  import cats.effect.unsafe.implicits.global
  import doodle.java2d.*
  import doodle.syntax.all.*

  // depicted to backend
  picture.draw()

}
