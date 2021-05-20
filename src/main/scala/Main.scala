package main

@main def hello = println("Hello")

extension (s: String) def twice = s ++ s

enum Color:
  case Red, Green, Blue
