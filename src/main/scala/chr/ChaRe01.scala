package chr

import chartreuse.{*, given}
import doodle.core.Point

import scala.util.Random
import chartreuse.layout.Scatter
import doodle.algebra
import doodle.algebra.{Shape, Style}

object ChaRe01 extends App {

  // raw data
  val data = List.fill(100)(Point(Random.nextGaussian(), Random.nextGaussian()))

  // where to put the data
  val layout: Scatter[Point, Shape & Style] = Scatter.default[Point]

  // data combined with layout
  val plot: Plot[Style & algebra.Layout & Shape] =
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
