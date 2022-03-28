(ns backend.spellChecker
  (:require [clojure.string :as str])
  (:import (org.apache.commons.lang3 StringUtils)))

;; ucitavanje reci iz fajla words.txt u varijablu words pomocu funkcije slurp

;; uklanjanje pratecih linija funkcijom strip-lines iz namespace-a clojure.string

;; uklanjanje razmaka(ako postoje) funkcijom strim iz namespace-a clojure.stirng

;; primena funkcije trim na svaku u setu pomocu funkcije map

;; funkcija set izvrsava kreiranje niza unikatnih reci
(def words
  (set (map str/trim (str/split-lines (slurp "resources/words.txt")))))

;; funkcija correct? koja kao argument uzima rec i proverava da li se ta rec nalazi
;; u nizu reci words
(defn correct? [word] (contains? words word))

;; funkcija distance uzima kao argument dve reci i vraca Levenstajnovo rastojanje te dve reci

;; Levenstajnovo rastojanje minimalan broj operacija neophodan
;; da se jedna promenljiva transformise u drugu
(defn distance [word1 word2]
  (StringUtils/getLevenshteinDistance word1 word2))

;; funkcija min-distance uzima kao arugment rec i vraca rec koja ima najmanje rastojanje

;; funkcija partial transformise funkciju distance tako da ona
;; uzima samo argument koji se prosledjuje funkciji min-distance

;; funkcija min-key vraca najmanju vrednost rezultata druge funkcije(koja se njoj prosledjuje)

;; funkcija apply primenjuje min-key i partial distance na words niz reci
(defn min-distance [word]
  (apply min-key (partial distance word) words))

;; main funkcija koja kao argument uzima rec i na osnovu odgovora funkcije correct? ispisuje
;; korisniku odgovarajuci odgovor
;; (defn checkSpelling [& args]
;;   (let [word (first args)]
;;     (if (correct? word)
;;       (println "correct")
;;       (println "Did you mean" (min-distance word) "?"))))

(defn checkSpelling [& args]
  (let [word (first args)]
    (if (correct? word)
      "correct"
      (min-distance word))))