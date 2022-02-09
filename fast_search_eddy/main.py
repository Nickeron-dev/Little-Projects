# -*- coding: utf-8 -*-
# encoding: utf-8
from __future__ import print_function

import webbrowser
import pyperclip
import time
import codecs


def main():
    previous_question = ""
    first_launch = True
    while True:
        try:
            site_code_file = codecs.open('../site_code.html', 'r', 'utf-8')
            string_file = site_code_file.read()
            REQUIRED_CLASS = "student-session-question-title"
            found_index = string_file.find(REQUIRED_CLASS)
            last_index = 0
            for i in range(len(string_file)):
                if string_file[found_index + len(REQUIRED_CLASS) + 3 + i] == '<':
                    last_index = i + 1
                    break
            site_code_file.close()
        except PermissionError as exc:
            print("OK")
            continue

        question = string_file[(found_index + len(REQUIRED_CLASS) + 2):(found_index + len(REQUIRED_CLASS) + 2
                                                                        + last_index)]
        if question != previous_question and not first_launch:
            previous_question = question
            pyperclip.copy(question)
            time.sleep(2)
            query = "https://www.google.com/"
            webbrowser.open(query)
            with open('all_questions_illia.txt', 'a', encoding="utf-8") as all_question_file:
                all_question_file.write(question + '\n')
            all_question_file.close()

        if first_launch:
            first_launch = False
            previous_question = question


if __name__ == '__main__':
    main()
