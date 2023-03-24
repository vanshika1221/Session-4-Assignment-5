package com.knoldus
import org.scalatest.funsuite.AnyFunSuite
class CrudOperationTest extends AnyFunSuite {
  val listObject = new MyList()

  test("To create and insert elements in the List") {
    val newObject = listObject.create(5).create(8).create(7).create(9)
    assert(newObject.read() == List(9,7,8,5))
  }
  test("To update an element in the List which is present") {
    val newObject = listObject.create(5).create(8).create(7).create(9)
    val updateObject = newObject.update(7,20)
    assert(updateObject.read() == List(9, 20, 8, 5))
  }
  test("To update element in the List which is not present") {
    val newObject = listObject.create(5).create(8).create(7).create(9)
    val updateObject = newObject.update(17, 20)
    assert(updateObject.read() == List(9, 7, 8, 5))
  }
  test("To delete an element from the List which is already present") {
    val newObject = listObject.create(5).create(8).create(7).create(9)
    val deleteObject = newObject.delete(8)
    assert(deleteObject.read() == List(9, 7, 5))
  }
  test("To delete an element from the List which is not present") {
    val newObject = listObject.create(5).create(8).create(7).create(9)
    val deleteObject = newObject.delete(90)
    assert(deleteObject.read() == List(9,7,8,5))
  }
  test("To delete an element from the empty List") {
    val deleteObject = listObject.delete(90)
    assert(deleteObject.read() == List())
  }
}
