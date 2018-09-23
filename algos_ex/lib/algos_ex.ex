defmodule Algos do
  # Selection sort
  @spec selection_sort(list) :: list
  def selection_sort(lst) when is_list(lst) do
    # Transform to a function that takes 2 args i.e. lst, acc
    do_selection(lst, [])
  end

  def do_selection([], acc) do
    acc
  end

  def do_selection([head | []], acc) do
    acc ++ [head]
  end

  def do_selection(lst, acc) do
    min = Enum.min(lst)
    do_selection(:lists.delete(min, lst), acc ++ [min])
  end

  def split(list) do
    len = (length(list) / 2) |> round
    Enum.split(list, len)
  end

  # Merge sort
  @spec merge_sort(list) :: list
  def merge_sort([]), do: []
  def merge_sort([x]), do: [x]

  def merge_sort(lst) do
    {left, right} = split(lst)
    merge(merge_sort(left), merge_sort(right), [])
  end

  # if right is empty, add all elements from the left
  def merge(left, [], acc), do: acc ++ left
  def merge([], right, acc), do: acc ++ right

  def merge(left = [left_head | left_tail], right = [right_head | right_tail], acc) do
    cond do
      # Add smallest element to end of accumulator
      left_head < right_head -> merge(left_tail, right, acc ++ [left_head])
      true -> merge(left, right_tail, acc ++ [right_head])
    end
  end
end
