package chr

import chartreuse.{*, given}
import doodle.core.Point

import scala.util.Random
import chartreuse.layout.{Curve, Line, Scatter}
import doodle.algebra
import doodle.algebra.{Path, Shape, Style}

import scala.util.Random

object ChaRe03 extends App {

  // raw data
  val data = List.fill(10)(Point(Random.nextGaussian(), Random.nextGaussian()))

  // where to put the data
  val layout: Curve[Point, Style & Path] = Curve.default[Point]

  // data combined with layout
  val plot: Plot[algebra.Layout & Style & Path] =
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
