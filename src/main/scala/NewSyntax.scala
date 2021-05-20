/** https://dotty.epfl.ch/docs/reference/enums/enums.html
  */
class NewSyntax {

  var x  = 3
  val xs = Some(2)
  val ys = Some(3)

  def f(x: Int) = x - 1

  if x < 0 then "negative"
  else if x == 0 then "zero"
  else "positive"

  if x < 0 then -x else x

  while x >= 0 do x = f(x)

  for x <- xs if x > 0
  yield x * x

  for
    x <- xs
    y <- ys
  do println(x + y)

  try println("juhu")
  catch case ex: Throwable => println("oh no")
}
