package chr

import chartreuse.{*, given}
import doodle.core.Point

import scala.util.Random
import chartreuse.layout.Scatter
import doodle.algebra.{Shape, Style}

object ChaRe00 extends App {

  val data =
    List.fill(100)(Point(Random.nextGaussian(), Random.nextGaussian()))

  val layout: Scatter[Point, Shape & Style] = Scatter.default[Point]

  val plot = layout
    .toPlot(data)
    .withPlotTitle("Our Amazing Plot")
    .withXTitle("Awesomeness")
    .withYTitle("Marvellousness")

  val picture = plot.draw(640, 480)

  import cats.effect.unsafe.implicits.global
  import doodle.java2d.*
  import doodle.syntax.all.*

  picture.draw()

}
