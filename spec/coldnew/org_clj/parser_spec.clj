(ns coldnew.org-clj.parser-spec
  (:require [speclj.core :refer :all]
            [speclj.run.standard]
            [coldnew.org-clj.parser :refer :all]))

(defn verify-header
  [{:keys [meta content callback-fn]}]
  (it (str meta " parser")
      (should (= (callback-fn (str meta content))
                 (callback-fn (str meta content "\n"))
                 (callback-fn (str meta content "\n\n"))
                 (callback-fn (str meta " " content))
                 (callback-fn (str meta "  " content))
                 (callback-fn (str meta "\t" content))
                 content))))

(describe
 "Document preamble"
 (verify-header {:meta        "#+TITLE:"
                 :content     "org-clj is an org-mode parser"
                 :callback-fn parse-title})
 (verify-header {:meta        "#+AUTHOR:"
                 :content     "Yen-Chin, Lee"
                 :callback-fn parse-author})
 (verify-header {:meta        "#+CREATOR:"
                 :content     "coldnew.tw@gmail.com"
                 :callback-fn parse-creator})
 (verify-header {:meta        "#+DATE:"
                 :content     "2015-06-08 21:05:24"
                 :callback-fn parse-date})
 (verify-header {:meta        "#+EMAIL:"
                 :content     "coldnew.tw@gmail.com"
                 :callback-fn parse-email})
 (verify-header {:meta        "#+LANGUAGE:"
                 :content     "zh-tw"
                 :callback-fn parse-language})
 (verify-header {:meta        "#+SELECT_TAGS:"
                 :content     "todo"
                 :callback-fn parse-select-tags})
 (verify-header {:meta        "#+EXCLUDE_TAGS:"
                 :content     "todo"
                 :callback-fn parse-exclude-tags})
 )
