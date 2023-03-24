package com.knoldus

abstract class CrudOperation {
  type  T
  def create(elements: T) :MyList
  def read() :List[T]
  def update(element: T,newElement: T) :MyList
  def delete(element: T,list: List[T]) :MyList
}

class MyList(val items: List[Int] = List.empty) extends CrudOperation {
  override type T = Int

  override def create(listElements: Int): MyList = {
    new MyList(listElements :: items)
  }

  override def read(): List[Int] = {
    items
  }

  override def update(elementToReplace: Int,newElement: Int): MyList = {
    val updatedList = items.map { item =>
       if(item == elementToReplace) newElement
       else item
  }
    new MyList(updatedList)
  }

  override def delete(elementToDelete: Int, emptyList: List[Int] = List.empty): MyList = {
         val updatedList = items.map { item =>
           if (item == elementToDelete) Nil
           else emptyList :+ item
         }
         new MyList(updatedList.flatten)
      }
  }
//class MySequence(val items: Seq[Int] = Seq.empty) extends CrudOperation{
//  override type T = Int
//
//  override def create(listElements: Int): MyList = {
//    new MyList(listElements :: items)
//  }
//
//  override def read(): List[Int] = {
//    items
//  }
//
//  override def update(elementToReplace: Int, newElement: Int): MyList = {
//    val updatedList = items.map { item =>
//      if (item == elementToReplace) newElement
//      else item
//    }
//    new MyList(updatedList)
//  }
//
//  override def delete(elementToDelete: Int, emptyList: List[Int] = List.empty): MyList = {
//    val updatedList = items.map { item =>
//      if (item == elementToDelete) Nil
//      else emptyList :+ item
//    }
//    new MyList(updatedList.flatten)
//  }
//}
//object A extends App {
//  val obj = new MyList
//  val k = obj.create(5).create(8).create(9).create(6)
//  //obj.create(7)
//  println(k.read())
// // val j = k.update(9,4)
// // println(j.read())
//  val d = k.delete(9)
//  println(d.read())
//}