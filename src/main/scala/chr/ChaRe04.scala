package chr

import chartreuse.component.{Annotation, AnnotationPosition, AnnotationType}
import chartreuse.{*, given}
import doodle.core.{Color, Point}

import scala.util.Random
import chartreuse.layout.{Curve, Line, Scatter}
import chartreuse.theme.PlotTheme
import doodle.algebra
import doodle.algebra.{Path, Shape, Style}

import scala.util.Random

object ChaRe04 extends App {

  // raw data
  val data = List.fill(10)(Point(Random.nextGaussian(), Random.nextGaussian()))

  // point described
  val annotationType = AnnotationType.CircleWithText(15, "achtung!")
  // description attached to point
  val annotation = Annotation(
//    Point(0,0),
    data.head,
    annotationType,
//    annotationPosition = AnnotationPosition.right,
//    arrow = true,
//    fillColor = Color.darkBlue,
//    strokeColor = Color.red,
//    strokeWidth = 5
  )
    .withAnnotationPosition(AnnotationPosition.right)

  // where to put the data
  val layout: Curve[Point, Style & Path] = Curve.default[Point]

  // data combined with layout
  val plot: Plot[algebra.Layout & Style & Path] =
    layout.toPlot(data)          // data attached to the plot
      .addAnnotation(annotation) // point with annotation added to the plot
      .withPlotTitle("Our Amazing Plot")
      .withXTitle("Awesomeness")
      .withYTitle("Marvellousness")

  // converted to picture
  val picture = plot.draw(640, 480, PlotTheme.base16.eighties)

  import cats.effect.unsafe.implicits.global
  import doodle.java2d.*
  import doodle.syntax.all.*

  // depicted to backend
  picture.draw()

}
