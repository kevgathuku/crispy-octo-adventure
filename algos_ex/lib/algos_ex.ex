defmodule Algos do
  @moduledoc """
  Documentation for Algos.
  """

  @doc """
  Hello world.

  ## Examples

      iex> Algos.hello()
      :world

  """
  def hello do
    :world
  end

  @spec selection_sort(list) :: list
  def selection_sort(lst) when is_list(lst) do
    # Transform to a function that takes 2 args i.e. head, acc
    do_selection(lst, [])
  end

  def do_selection([head | []], acc) do
    acc ++ [head]
  end

  def do_selection(lst, acc) do
    min = Enum.min(lst)
    do_selection(:lists.delete(min, lst), acc ++ [min])
  end
end
