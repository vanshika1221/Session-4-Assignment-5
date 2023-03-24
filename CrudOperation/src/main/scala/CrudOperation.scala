package com.knoldus

abstract class CrudOperation {
  type T

  def create(elements: T): Seq[T]

  def read(): Seq[T]

  def update(element: T, newElement: T): Seq[T]

  def delete(element: T, collection: Seq[T]): Seq[T]
}

// List class
class MyList extends CrudOperation {
  override type T = Int
  var listItems = List.empty[Int]

  override def create(listElements: Int): List[Int] = {
    listItems = listElements :: listItems
    listItems
  }

  override def read(): List[Int] = {
    listItems
  }

  override def update(elementToReplace: Int, newElement: Int): List[Int] = {
    if (listItems.indexOf(elementToReplace) == -1) throw new IndexOutOfBoundsException()
    listItems = listItems.updated(listItems.indexOf(elementToReplace), newElement)
    listItems
  }

  override def delete(elementToDelete: Int, emptyList: Seq[Int] = List.empty): List[Int] = {
    if (listItems.contains(elementToDelete)) {
      listItems = listItems.filterNot(_ == elementToDelete)
      listItems
    } else throw new NoSuchElementException

  }
}

//Sequence class
class MySequence extends CrudOperation {
  override type T = Int
  var sequenceItems = Seq.empty[Int]

  override def create(sequenceElements: Int): Seq[Int] = {
    sequenceItems = sequenceItems :+ sequenceElements
    sequenceItems
  }

  override def read(): Seq[Int] = {
    sequenceItems
  }

  override def update(elementToReplace: Int, newElement: Int): Seq[Int] = {
    if (sequenceItems.indexOf(elementToReplace) == -1) throw new IndexOutOfBoundsException()
    sequenceItems = sequenceItems.updated(sequenceItems.indexOf(elementToReplace), newElement)
    sequenceItems
  }

  override def delete(elementToDelete: Int, emptySequence: Seq[Int] = Seq.empty): Seq[Int] = {
    if (sequenceItems.contains(elementToDelete)) {
      sequenceItems = sequenceItems.filterNot(_ == elementToDelete)
      sequenceItems
    } else throw new NoSuchElementException
  }
}
