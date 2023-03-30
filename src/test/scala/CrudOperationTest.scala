package com.knoldus
import org.scalatest.funsuite.AnyFunSuite
class CrudOperationTest extends AnyFunSuite {

  val listObject = new MyList()
  listObject.create(5)
  listObject.create(8)

  val sequenceObject = new MySequence()
  sequenceObject.create(15)
  sequenceObject.create(81)

 // List test cases
  test("To create and insert elements in the List") {
    listObject.create(33)
    assert(listObject.read() == List(33,8,5))
  }
  test("To update an element in the List which is present") {
    listObject.update(5,20)
    assert(listObject.read() == List(33,8,20))
  }
  test("To update element in the List which is not present") {
    assertThrows[IndexOutOfBoundsException] {
      listObject.update(15, 20)
    }
  }
  test("To delete an element from the List which is already present") {
    listObject.delete(20)
    assert(listObject.read() == List(33,8))
  }
  test("To delete an element from the List which is not present") {
    assertThrows[NoSuchElementException] {
      listObject.delete(12)
    }
  }
// Sequence Test cases
  test("To create and insert elements in the Sequence") {
    sequenceObject.create(45)
    assert(sequenceObject.read() == List(15,81,45))
  }
  test("To update an element in the Sequence which is present") {
    sequenceObject.update(15, 20)
    assert(sequenceObject.read() == List(20,81,45))
  }
  test("To update element in the Sequence which is not present") {
    assertThrows[IndexOutOfBoundsException] {
      sequenceObject.update(5, 20)
    }
  }
  test("To delete an element from the Sequence which is already present") {
    sequenceObject.delete(20)
    assert(sequenceObject.read() == List(81,45))
  }
  test("To delete an element from the Sequence which is not present") {
    assertThrows[NoSuchElementException] {
      sequenceObject.delete(12)
    }
  }

}
