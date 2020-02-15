//
// Created by danila on 13.02.20.
//

#ifndef MY_APPLICATION2_MYDATA_H
#define MY_APPLICATION2_MYDATA_H

#include <vector>
#include <string>

using std::vector;
using std::string;

class MyData {

    string english_word;
    vector translation;
    size_t count_true_answers;
    size_t count_bad_answers;

public:
    MyData() = delete;

    ~MyData() = default;

    MyData(string, vector);

    void plusTrueCheck(){
        ++count_true_answers;
    }

    void plusBadCheck(){
        ++count_bad_answers;
    }

    void zeroCheck(){

        count_true_answers = 0;
        count_bad_answers = 0;
    }

    string getWord() {

        return english_word;
    }

    vector getTranslate() {

        return translation;
    }


};



#endif //MY_APPLICATION2_MYDATA_H
