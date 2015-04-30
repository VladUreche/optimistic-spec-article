package respec

import scala.util.Random

import org.openjdk.jmh.annotations.{ Benchmark, Scope, State }

class VecMapBenchmark {

//  @Benchmark
//  def doubleSquareDoubleArrayWithLoop(data: MapData) = {
//    val xs = data.doubleData
//    val ys = new Array[Double](xs.length)
//    var i = 0
//    while (i < xs.length) {
//      val x = xs(i)
//      ys(i) = x * x
//      i += 1
//    }
//    ys
//  }
//
//  @Benchmark
//  def doubleSquareDoubleArrayWithMap(data: MapData) =
//    data.doubleData.map(x => x * x)
//
//  @Benchmark
//  def doubleSquareDoubleVec(data: MapData) =
//    data.doubleVec.map(x => x * x)

  @Benchmark
  def intSquareDoubleArrayWithLoop(data: MapData) = {
    val xs = data.intData
    val ys = new Array[Int](xs.length)
    var i = 0
    while (i < xs.length) {
      val x = xs(i)
      ys(i) = x * x
      i += 1
    }
    ys
  }

//  @Benchmark
//  def intSquareDoubleArrayWithMap(data: MapData) =
//    data.intData.map(x => x * x)

  @Benchmark
  def intSquareDoubleVec(data: MapData) =
    data.intVec.map(x => x * x)
}

@State(Scope.Benchmark)
class MapData {
  val size = 1000
  val rng = new Random(42)
  val doubleData: Array[Double] = Array.fill(size)(rng.nextDouble)
  val doubleVec: Vec[Double] = Vec(doubleData)
  val intData: Array[Int] = Array.fill(size)(rng.nextInt)
  val intVec: Vec[Int] = Vec(intData)
  // force all array types
  println("Forcing different array types:")
  val byteArray = MbArray.empty[Byte](2)
  byteArray(0) = byteArray(1)
  println(byteArray.getClass)
  val charArray = MbArray.empty[Char](2)
  charArray(0) = charArray(1)
  println(charArray.getClass)
  val longArray = MbArray.empty[Long](2)
  longArray(0) = longArray(1)
  println(longArray.getClass)
  val intArray = MbArray.empty[Int](2)
  intArray(0) = intArray(1)
  println(intArray.getClass)
  val shortArray = MbArray.empty[Short](2)
  shortArray(0) = shortArray(1)
  println(shortArray.getClass)
  val floatArray = MbArray.empty[Float](2)
  floatArray(0) = floatArray(1)
  println(floatArray.getClass)
  val doubleArray = MbArray.empty[Double](2)
  doubleArray(0) = doubleArray(1)
  println(longArray.getClass)
}
