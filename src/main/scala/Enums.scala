// https://dotty.epfl.ch/docs/reference/enums/enums.html
enum NamedColor:
  case Red, Green, Blue

enum HexColor(val rgb: Int):
  case Red extends HexColor(0xff0000)
  case Green extends HexColor(0x00ff00)
  case Blue extends HexColor(0x0000ff)
