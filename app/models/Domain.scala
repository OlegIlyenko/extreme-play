package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class NewPlayer(name: String, url: String) {
  require(!name.isEmpty, "Name shouldn't be empty")
  require(name.forall(_.isLetterOrDigit), "Only letters and digits are allowed for player name")
  require(!url.isEmpty, "URL shouldn't be empty")
}

object NewPlayer {
  implicit val newPlayerFormat : Format[NewPlayer] = Json.format[NewPlayer]
}

case class Task(query: String, score: Int = 0) {
  def scoreAnswer(answer: String) = if (verify(answer)) score else -score
  def verify(answer: String): Boolean = true
}
