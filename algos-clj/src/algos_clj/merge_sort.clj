
(defn merge-fn [[x & xrest :as left] [y & yrest :as right] acc]
  ;; Can be used in place of loop in the merge-sort function
  ;; However, it results in a StackOverflowError for large collections
  (if (and (not-empty left) (not-empty right))
    ;; x is smaller, extract it and add it to the acc
    ;; conj adds the item to the end, since we're working with vectors
      (if (<= x y) (merge xrest right (conj acc x))
          (merge left yrest (conj acc y)))
      ;; if one is empty, concat the non-empty coll to the end of acc
      (concat acc left right)))


(defn merge-sort [lst]
  (if (> (count lst) 1)
      (let [halves (split-at (/ (count lst) 2) lst)]
        ;; recursive call - Can call the merge-fn here instead
        ;; loop enables tail-recursive-optimization
        (loop [left (merge-sort (first halves)) right (merge-sort (second halves)) acc []]
          (if (and (not-empty left) (not-empty right))
            (if (<= (first left) (first right))
              (recur (rest left) right (conj acc (first left)))
              (recur left (rest right) (conj acc (first right))))
            ;; when one of the collections is empty, concat both to acc
            (concat acc left right))))
    lst))

