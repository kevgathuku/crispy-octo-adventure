defmodule AlgosTest do
  use ExUnit.Case
  doctest Algos

  test "greets the world" do
    assert Algos.hello() == :world
  end

  test "Selection sort: Sorts numbers" do
    lst = [19, 64, 5, 9, 12]
    expected = [5, 9, 12, 19, 64]
    assert Algos.selection_sort(lst) == expected
  end
end
