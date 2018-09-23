defmodule AlgosTest do
  use ExUnit.Case
  use Quixir
  doctest Algos

  test "greets the world" do
    assert Algos.hello() == :world
  end

  # Selection sort
  test "sorts unsorted numbers" do
    lst = [19, 64, 5, 9, 12]
    expected = [5, 9, 12, 19, 64]
    assert Algos.selection_sort(lst) == expected
  end

  test "sorts lists with any type" do
    ptest original: list() do
      assert Algos.selection_sort(original) == Enum.sort(original)
    end
  end

  test "a sorted list has the same length as the original" do
    ptest original: list() do
      sorted = Algos.selection_sort(original)
      assert length(sorted) == length(original)
    end
  end

  test "sorting a list of length 1 does nothing" do
    ptest original: list(1) do
      assert Algos.selection_sort(original) == original
    end
  end
end
